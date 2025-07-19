package com.lab3.finalproject.service;

import com.lab3.finalproject.model.Alumno;
import com.lab3.finalproject.model.AsignaturaEstado;
import com.lab3.finalproject.model.Estado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService {

    private List<Alumno> alumnos = new ArrayList<>();
    private Long nextId = 1L;

    public Alumno crearAlumno(Alumno alumno) {
        alumno.setId(nextId++);
        alumnos.add(alumno);
        return alumno;
    }

    public boolean actualizarEstadoAsignatura(Long idAlumno, Long idAsignatura, String nuevoEstado) {
        Alumno alumno = obtenerAlumnoPorId(idAlumno);
        if (alumno == null) return false;

        for (AsignaturaEstado ae : alumno.getAsignaturasEstado()) {
            if (ae.getAsignatura().getId().equals(idAsignatura)) {
                ae.setEstado(Estado.valueOf(nuevoEstado.toUpperCase()));
                return true;
            }
        }
        return false;
    }

    public Alumno modificarAlumno(Long id, Alumno alumnoActualizado) {
        for (Alumno a : alumnos) {
            if (a.getId().equals(id)) {
                a.setNombre(alumnoActualizado.getNombre());
                a.setApellido(alumnoActualizado.getApellido());
                a.setDni(alumnoActualizado.getDni());
                a.setAsignaturasEstado(alumnoActualizado.getAsignaturasEstado());
                return a;
            }
        }
        return null;
    }

    public boolean eliminarAlumno(Long id) {
        return alumnos.removeIf(a -> a.getId().equals(id));
    }

    public List<Alumno> listarAlumnos() {
        return alumnos;
    }

    public Alumno obtenerAlumnoPorId(Long id) {
        return alumnos.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }
}
