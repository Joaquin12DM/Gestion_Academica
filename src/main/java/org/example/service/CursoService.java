package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Curso;

import java.util.List;

public class CursoService {

    List<Curso> cursosPrueba = List.of(
            new Curso("Matemáticas I", "C101", 4),
            new Curso("Física General", "C102", 4),
            new Curso("Química Orgánica", "C103", 4),
            new Curso("Lengua y Literatura", "C104", 3),
            new Curso("Historia Universal", "C105", 3),
            new Curso("Biología Celular", "C106", 4),
            new Curso("Educación Física", "C107", 2),
            new Curso("Filosofía Moderna", "C108", 3),
            new Curso("Introducción a la Computación", "C109", 4),
            new Curso("Inglés Básico", "C110", 3),
            new Curso("Economía General", "C111", 3),
            new Curso("Arte y Cultura", "C112", 2),
            new Curso("Geografía Física", "C113", 3),
            new Curso("Psicología Social", "C114", 3),
            new Curso("Música Aplicada", "C115", 2)
    );

    public void crearCursoPrueba(EntityManager em) {
        crearCursos(em, cursosPrueba);
    }

    public void crearCursos(EntityManager em, List<Curso> cursos) {

        em.getTransaction().begin();

        try {
            for (Curso curso : cursos) {
                em.persist(curso);
            }

            em.getTransaction().commit();
            System.out.println("Cursos de prueba registrados");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al registrar cursos: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
