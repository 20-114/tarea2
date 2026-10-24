package com.docente.usuariosjson.controller;

import com.docente.usuariosjson.dto.HeroeDto;
import com.docente.usuariosjson.service.HeroesService;
import com.docente.usuariosjson.service.HeroesServiceArchivo;
import com.docente.usuariosjson.service.IHeroesService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class HeroesController {
    @FXML
    public TextField txtId;
    @FXML
    public TextField txtNombre;
    @FXML
    public TableView tableHeroes;
    @FXML
    public TableColumn<HeroeDto, Integer> colId;
    @FXML
    public TableColumn<HeroeDto, String> colNombre;
    @FXML
    public Button btnEliminar;
    @FXML
    public Button btnModificar;

    private ObservableList<HeroeDto> listaObservable;
    private IHeroesService heroesService;
    private Integer id = 0;

    public HeroesController() {
        this.heroesService = new HeroesServiceArchivo();
    }

    public Integer contadorID(){
        this.id += 1;
        return id;
    }

    @FXML
    public void handleCrear(MouseEvent mouseEvent) {
        Integer id = contadorID();
        String nombre = txtNombre.getText();
        HeroeDto heroeDto = new HeroeDto(id, nombre);
        this.heroesService.crearHeroe(heroeDto);
    }

    @FXML
    public void handleSeleccionado(MouseEvent mouseEvent) {
        System.out.println(this.heroesService.obtenerHeroes().size());
        for (HeroeDto heroe : this.heroesService.obtenerHeroes()) {
            System.out.println(heroe);
        }
    }

    @FXML
    public void handleEliminar(MouseEvent mouseEvent) {
        Integer id = Integer.parseInt(txtId.getText());
        for (HeroeDto heroe : this.heroesService.obtenerHeroes()) {
            if (id.equals(heroe.id())) {
                heroesService.eliminarHeroe(heroe);
            }
        }
    }

    public void handleModificarHeroe(MouseEvent mouseEvent) {
        Integer id = Integer.parseInt(txtId.getText());
        HeroeDto heroeActualizado = new HeroeDto(id, txtNombre.getText());
        for (HeroeDto heroe : this.heroesService.obtenerHeroes()) {
            if (id.equals(heroe.id())) {
                heroesService.actualizarNombreHeroe(heroe, heroeActualizado);
            }
        }
    }
}
