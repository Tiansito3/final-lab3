package com.lab3.finalproject.service;

import com.lab3.finalproject.model.Alumno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoServiceTest {

    @Test
    void crearAlumno_agregaAlumnoALaLista() {
        AlumnoService alumnoService = new AlumnoService();
        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setApellido("Castellano");
        alumno.setDni("12345678");

        Alumno resultado = alumnoService.crearAlumno(alumno);

        assertNotNull(resultado.getId());
        assertEquals("Juan", resultado.getNombre());
        assertEquals(1, alumnoService.listarAlumnos().size());
    }
}
