package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fechaInscripcion")
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(name="estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

    @Column(name="estado",columnDefinition = "VARCHAR")
    private Estado estado;
    
     enum Estado{
        PENDIENTE, CONFIRMADA, CANCELADA
    }


    public Inscripcion() {
    }

    public Inscripcion(LocalDate fechaInscripcion, Curso curso, Estado estado, Estudiante estudiante) {
        this.fechaInscripcion = fechaInscripcion;
        this.curso = curso;
        this.estado = estado;
        this.estudiante = estudiante;
    }

    public Inscripcion(Curso curso, Estudiante estudiante, LocalDate fechaInscripcion) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
