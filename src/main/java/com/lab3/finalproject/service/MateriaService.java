
package com.lab3.finalproject.service;

import com.lab3.finalproject.model.Materia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    private final List<Materia> materias = new ArrayList<>();
    private Long nextId = 1L;

    public List<Materia> obtenerTodas() {
        return materias;
    }

    public Materia crearMateria(Materia materia) {
        materia.setId(nextId++);
        materias.add(materia);
        return materia;
    }

    public Materia modificarMateria(Long id, Materia materia) {
        Optional<Materia> existente = materias.stream().filter(m -> m.getId().equals(id)).findFirst();
        if (existente.isPresent()) {
            existente.get().setNombre(materia.getNombre());
            existente.get().setCodigo(materia.getCodigo());
            return existente.get();
        }
        return null;
    }

    public void eliminarMateria(Long id) {
        materias.removeIf(m -> m.getId().equals(id));
    }
}
