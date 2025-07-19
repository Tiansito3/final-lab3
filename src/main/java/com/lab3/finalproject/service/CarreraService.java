package com.lab3.finalproject.service;

import com.lab3.finalproject.model.Carrera;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarreraService {

    private List<Carrera> carreras = new ArrayList<>();
    private Long nextId = 1L;

    public Carrera crearCarrera(Carrera carrera) {
        carrera.setId(nextId++);
        carreras.add(carrera);
        return carrera;
    }

    public Carrera modificarCarrera(Long id, Carrera actualizada) {
        for (Carrera c : carreras) {
            if (c.getId().equals(id)) {
                c.setNombre(actualizada.getNombre());
                c.setCodigoCarrera(actualizada.getCodigoCarrera());
                c.setDepartamento(actualizada.getDepartamento());
                c.setCantidadCuatrimestres(actualizada.getCantidadCuatrimestres());
                return c;
            }
        }
        return null;
    }

    public boolean eliminarCarrera(Long id) {
        return carreras.removeIf(c -> c.getId().equals(id));
    }

    public List<Carrera> listarCarreras() {
        return carreras;
    }

    public Carrera obtenerCarreraPorId(Long id) {
        return carreras.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }
}
