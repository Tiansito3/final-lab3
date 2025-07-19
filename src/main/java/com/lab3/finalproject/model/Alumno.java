package com.lab3.finalproject.model;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private List<AsignaturaEstado> asignaturasEstado = new ArrayList<>();

    public Alumno() {}

    public Alumno(Long id, String nombre, String apellido, String dni, List<AsignaturaEstado> asignaturasEstado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.asignaturasEstado = asignaturasEstado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public List<AsignaturaEstado> getAsignaturasEstado() {
        return asignaturasEstado;
    }

    public void setAsignaturasEstado(List<AsignaturaEstado> asignaturasEstado) {
        this.asignaturasEstado = asignaturasEstado;
    }
}
