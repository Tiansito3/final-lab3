package com.lab3.finalproject.model;

import java.util.List;

public class Carrera {
    private Long id;
    private String nombre;
    private String codigoCarrera;
    private Integer departamento;  // Puede ser un id para simplificar
    private Integer cantidadCuatrimestres;
    private List<Materia> materias;  // Lista de materias asociadas a esta carrera

    public Carrera() {}

    public Carrera(Long id, String nombre, String codigoCarrera, Integer departamento, Integer cantidadCuatrimestres, List<Materia> materias) {
        this.id = id;
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
        this.departamento = departamento;
        this.cantidadCuatrimestres = cantidadCuatrimestres;
        this.materias = materias;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigoCarrera() { return codigoCarrera; }
    public void setCodigoCarrera(String codigoCarrera) { this.codigoCarrera = codigoCarrera; }

    public Integer getDepartamento() { return departamento; }
    public void setDepartamento(Integer departamento) { this.departamento = departamento; }

    public Integer getCantidadCuatrimestres() { return cantidadCuatrimestres; }
    public void setCantidadCuatrimestres(Integer cantidadCuatrimestres) { this.cantidadCuatrimestres = cantidadCuatrimestres; }

    public List<Materia> getMaterias() { return materias; }
    public void setMaterias(List<Materia> materias) { this.materias = materias; }
}
