
package com.lab3.finalproject.model;

public class Materia {
    private Long id;
    private String nombre;
    private String codigo;
    private Carrera carrera;  // <-- Nueva relación: materia pertenece a una carrera

    public Materia() {}

    public Materia(Long id, String nombre, String codigo, Carrera carrera) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.carrera = carrera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
