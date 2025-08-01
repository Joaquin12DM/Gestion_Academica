package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entity.Curso;
import org.example.entity.Profesor;

import java.util.List;

public class ProfesorService {

    //Solo para crear datos de prueba
    public List<Profesor> crearProfesores(EntityManager em) {
        List<Profesor> profesores = List.of(
                new Profesor("Roberto", "Matemáticas"),
                new Profesor("Cecilia", "Física"),
                new Profesor("Héctor", "Química"),
                new Profesor("Patricia", "Lengua y Literatura"),
                new Profesor("Gustavo", "Historia"),
                new Profesor("Lucía", "Biología"),
                new Profesor("Eduardo", "Educación Física"),
                new Profesor("Verónica", "Filosofía"),
                new Profesor("Raúl", "Computación"),
                new Profesor("Diana", "Inglés"),
                new Profesor("Oscar", "Economía"),
                new Profesor("Fernanda", "Arte"),
                new Profesor("Jose", "Geografía"),
                new Profesor("Adriana", "Psicología"),
                new Profesor("Alberto", "Música")
        );
        em.getTransaction().begin();
        try {
            for (Profesor profesor : profesores) {
                em.persist(profesor);
            }
            for (int i = 0; i < profesores.size(); i++) {
                Curso curso = em.find(Curso.class, (long)(i+1));
                if (curso != null) {
                    profesores.get(i).getCursos().add(curso);
                    em.merge(profesores.get(i));
                }
            }
            em.getTransaction().commit();
            System.out.println("Profesores creados y cursos asignados correctamente");
            return profesores;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }


}
