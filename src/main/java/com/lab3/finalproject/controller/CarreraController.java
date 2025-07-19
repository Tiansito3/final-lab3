// CarreraController.java
package com.lab3.finalproject.controller;

import com.lab3.finalproject.model.Carrera;
import com.lab3.finalproject.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @PostMapping
    public Carrera crearCarrera(@RequestBody Carrera carrera) {
        return carreraService.crearCarrera(carrera);
    }

    @PutMapping("/{id}")
    public Carrera modificarCarrera(@PathVariable("id") Long id, @RequestBody Carrera carrera) {
        return carreraService.modificarCarrera(id, carrera);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable("id") Long id) {
        carreraService.eliminarCarrera(id);
    }

    @GetMapping
    public List<Carrera> listarCarreras() {
        return carreraService.listarCarreras();
    }
}
