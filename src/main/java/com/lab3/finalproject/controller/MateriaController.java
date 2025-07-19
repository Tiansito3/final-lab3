// MateriaController.java
package com.lab3.finalproject.controller;

import com.lab3.finalproject.model.Materia;
import com.lab3.finalproject.service.MateriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public List<Materia> getMaterias() {
        return materiaService.obtenerTodas();
    }

    @PostMapping
    public Materia crearMateria(@RequestBody Materia materia) {
        return materiaService.crearMateria(materia);
    }

    @PutMapping("/{id}")
    public Materia modificarMateria(@PathVariable("id") Long id, @RequestBody Materia materia) {
        return materiaService.modificarMateria(id, materia);
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable("id") Long id) {
        materiaService.eliminarMateria(id);
    }
}
