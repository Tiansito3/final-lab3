// AlumnoController.java
package com.lab3.finalproject.controller;

import com.lab3.finalproject.model.Alumno;
import com.lab3.finalproject.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.crearAlumno(alumno);
    }

    @PutMapping("/{id}")
    public Alumno modificarAlumno(@PathVariable("id") Long id, @RequestBody Alumno alumno) {
        return alumnoService.modificarAlumno(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable("id") Long id) {
        alumnoService.eliminarAlumno(id);
    }

    @PutMapping("/{idAlumno}/asignatura/{idAsignatura}")
    public ResponseEntity<String> actualizarAsignatura(
            @PathVariable("idAlumno") Long idAlumno,
            @PathVariable("idAsignatura") Long idAsignatura,
            @RequestParam("estado") String estado) {

        boolean actualizado = alumnoService.actualizarEstadoAsignatura(idAlumno, idAsignatura, estado);

        if (actualizado) {
            return ResponseEntity.ok("Estado de asignatura actualizado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Alumno> listarAlumnos() {
        return alumnoService.listarAlumnos();
    }
}
