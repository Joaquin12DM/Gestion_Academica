package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entity.Curso;
import org.example.entity.Profesor;

import java.util.List;

public class ProfesorService {

    List<Profesor> profesoresPrueba = List.of(
            new Profesor("Roberto Salazar", "Matemáticas"),
            new Profesor("Cecilia Ramos", "Física"),
            new Profesor("Héctor Villanueva", "Química"),
            new Profesor("Patricia Guzmán", "Lengua y Literatura"),
            new Profesor("Gustavo Paredes", "Historia"),
            new Profesor("Lucía Romero", "Biología"),
            new Profesor("Eduardo Palacios", "Educación Física"),
            new Profesor("Verónica Silva", "Filosofía"),
            new Profesor("Raúl Mendoza", "Computación"),
            new Profesor("Diana Carrillo", "Inglés"),
            new Profesor("Oscar Delgado", "Economía"),
            new Profesor("María Fernanda Ruiz", "Arte"),
            new Profesor("José Miguel Bravo", "Geografía"),
            new Profesor("Adriana Cárdenas", "Psicología"),
            new Profesor("Carlos Alberto León", "Música")
    );

    public void crearProfesoresPrueba(EntityManager em) {
        crearProfesores(em, profesoresPrueba);
    }

    public void crearProfesores(EntityManager em, List<Profesor> profesores) {

        em.getTransaction().begin();

        try {
            for (Profesor prof : profesores) {
                em.persist(prof);
            }

            em.getTransaction().commit();
            System.out.println("Profesores de prueba creados");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al registrar profesores: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void asociarProfesoresACursos(EntityManager em) {
        em.getTransaction().begin();

        for (int i = 1; i <= 15; i++) {
            Curso curso = em.find(Curso.class, (long)i);
            Profesor profesor = em.find(Profesor.class, (long)i);
            if (curso != null && profesor != null) {
                curso.setProfesor(profesor);

                em.persist(curso);
            }
        }
        em.getTransaction().commit();
        System.out.println("Asignación correcta de Profesor con Curso para prueba");
    }


}
