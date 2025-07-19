package com.lab3.finalproject.service;

import com.lab3.finalproject.model.Carrera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarreraServiceTest {

    @Test
    void crearCarrera_agregaCarreraALaLista() {
        CarreraService carreraService = new CarreraService();
        Carrera carrera = new Carrera();
        carrera.setNombre("Ingeniería en Sistemas");

        Carrera resultado = carreraService.crearCarrera(carrera);

        assertNotNull(resultado.getId());
        assertEquals("Ingeniería en Sistemas", resultado.getNombre());
        assertEquals(1, carreraService.listarCarreras().size());
    }

    @Test
    void modificarCarrera_actualizaCampos() {
        CarreraService carreraService = new CarreraService();
        Carrera carrera = new Carrera();
        carrera.setNombre("Licenciatura");
        carreraService.crearCarrera(carrera);

        Carrera nueva = new Carrera();
        nueva.setNombre("Licenciatura en Matemática");

        Carrera modificado = carreraService.modificarCarrera(1L, nueva);

        assertNotNull(modificado);
        assertEquals("Licenciatura en Matemática", modificado.getNombre());
    }

    @Test
    void eliminarCarrera_funciona() {
        CarreraService carreraService = new CarreraService();
        Carrera carrera = new Carrera();
        carrera.setNombre("Bioquímica");
        carreraService.crearCarrera(carrera);

        carreraService.eliminarCarrera(1L);

        assertEquals(0, carreraService.listarCarreras().size());
    }
}
