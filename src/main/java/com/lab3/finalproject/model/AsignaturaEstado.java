package com.lab3.finalproject.model;

public class AsignaturaEstado {
    private Long id;
    private Materia asignatura;  // referencia a la materia/asignatura
    private Estado estado;

    public AsignaturaEstado() {}

    public AsignaturaEstado(Long id, Materia asignatura, Estado estado) {
        this.id = id;
        this.asignatura = asignatura;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Materia getAsignatura() { return asignatura; }
    public void setAsignatura(Materia asignatura) { this.asignatura = asignatura; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}
