package com.docente.usuariosjson.service;

import com.docente.usuariosjson.dto.HeroeDto;

import java.util.ArrayList;

public class HeroesService implements IHeroesService {
    private ArrayList<HeroeDto> listado;

    public HeroesService() {
        this.listado = new ArrayList<>();
    }
    @Override
    public void crearHeroe(HeroeDto heroe) {
        this.listado.add(heroe);
    }

    @Override
    public ArrayList<HeroeDto> obtenerHeroes() {
        return this.listado;
    }

    @Override
    public void eliminarHeroe(HeroeDto heroe) {
        listado.remove(heroe);
    }

    @Override
    public void actualizarNombreHeroe(HeroeDto heroe, HeroeDto heroeActualizado) {
        listado.remove(heroe);
        listado.add(heroeActualizado);

    }



}
