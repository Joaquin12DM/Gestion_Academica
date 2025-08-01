package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre",length = 100,nullable = false)
    private String nombre;

    @Column(name="codigo",length = 20,nullable = false)
    private String codigo;

    @Column(name="creditos")
    private int creditos;

    @ManyToMany(mappedBy = "cursos")
    private List<Profesor> profesores = new ArrayList<>();


    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Inscripcion> inscripciones = new ArrayList<>();


    public Curso() {
    }

    public Curso(String nombre, String codigo, int creditos, List<Profesor> profesores, List<Inscripcion> inscripciones) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.profesores = profesores;
        this.inscripciones = inscripciones;
    }

    public Curso(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void setProfesor(Profesor profesor) {

    }
}
