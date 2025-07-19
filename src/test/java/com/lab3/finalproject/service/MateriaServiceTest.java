package com.lab3.finalproject.service;

import com.lab3.finalproject.model.Materia;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MateriaServiceTest {

    @Test
    void crearMateria_agregaMateriaALaLista() {
        MateriaService materiaService = new MateriaService();
        Materia materia = new Materia();
        materia.setNombre("Matemática");
        materia.setCodigo("MAT101");

        Materia resultado = materiaService.crearMateria(materia);

        assertNotNull(resultado.getId());
        assertEquals("Matemática", resultado.getNombre());
        assertEquals(1, materiaService.obtenerTodas().size());
    }

    @Test
    void modificarMateria_actualizaCampos() {
        MateriaService materiaService = new MateriaService();
        Materia materia = new Materia();
        materia.setNombre("Física");
        materia.setCodigo("FIS101");
        materiaService.crearMateria(materia);

        Materia nueva = new Materia();
        nueva.setNombre("Física II");
        nueva.setCodigo("FIS201");

        Materia modificado = materiaService.modificarMateria(1L, nueva);

        assertNotNull(modificado);
        assertEquals("Física II", modificado.getNombre());
        assertEquals("FIS201", modificado.getCodigo());
    }

    @Test
    void eliminarMateria_funciona() {
        MateriaService materiaService = new MateriaService();
        Materia materia = new Materia();
        materia.setNombre("Química");
        materia.setCodigo("QUI101");
        materiaService.crearMateria(materia);

        materiaService.eliminarMateria(1L);

        assertEquals(0, materiaService.obtenerTodas().size());
    }
}
