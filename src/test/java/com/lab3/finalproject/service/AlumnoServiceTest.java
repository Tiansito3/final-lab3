package com.lab3.finalproject.service;

import com.lab3.finalproject.model.Alumno;
import com.lab3.finalproject.model.AsignaturaEstado;
import com.lab3.finalproject.model.Materia;
import com.lab3.finalproject.model.Estado;
import com.lab3.finalproject.model.Carrera;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoServiceTest {

    @Test
    void crearYActualizarEstadoAsignatura() {
        AlumnoService alumnoService = new AlumnoService();

        // Crear una materia (usando el constructor real)
        Materia materia = new Materia(1L, "Matemática", "MAT101", null); // Le pasamos null como carrera

        // Crear el AsignaturaEstado (materia + estado)
        AsignaturaEstado asignaturaEstado = new AsignaturaEstado(1L, materia, Estado.CURSANDO);

        // Crear el alumno y asociarle la asignatura con estado
        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setApellido("Castellano");
        alumno.setDni("12345678");
        alumno.setAsignaturasEstado(Collections.singletonList(asignaturaEstado));

        // Crear alumno en el servicio
        Alumno creado = alumnoService.crearAlumno(alumno);

        // Verificar que se creó bien
        assertNotNull(creado.getId());
        assertEquals("Juan", creado.getNombre());
        assertEquals(1, creado.getAsignaturasEstado().size());
        assertEquals("Matemática", creado.getAsignaturasEstado().get(0).getAsignatura().getNombre());
        assertEquals(Estado.CURSANDO, creado.getAsignaturasEstado().get(0).getEstado());

        // Cambiar estado de la materia para ese alumno
        boolean actualizado = alumnoService.actualizarEstadoAsignatura(
                creado.getId(),
                materia.getId(),
                "APROBADA"
        );
        assertTrue(actualizado);

        // Verificar que el estado se haya actualizado en la lista
        Alumno buscado = alumnoService.obtenerAlumnoPorId(creado.getId());
        assertEquals(Estado.APROBADA, buscado.getAsignaturasEstado().get(0).getEstado());
    }
}
