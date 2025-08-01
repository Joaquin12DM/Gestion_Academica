package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Curso;

import java.util.List;

public class CursoService {

    List<Curso> cursosPrueba = List.of(
            new Curso("Matemáticas I", "MAT101", 4),
            new Curso("Física General", "FIS102", 4),
            new Curso("Química Orgánica", "QUI103", 4),
            new Curso("Lengua y Literatura", "LEN104", 3),
            new Curso("Historia Universal", "HIS105", 3),
            new Curso("Biología Celular", "BIO106", 4),
            new Curso("Educación Física", "EDF107", 2),
            new Curso("Filosofía Moderna", "FIL108", 3),
            new Curso("Introducción a la Computación", "COM109", 4),
            new Curso("Inglés Básico", "ING110", 3),
            new Curso("Economía General", "ECO111", 3),
            new Curso("Arte y Cultura", "ART112", 2),
            new Curso("Geografía Física", "GEO113", 3),
            new Curso("Psicología Social", "PSI114", 3),
            new Curso("Música Aplicada", "MUS115", 2)
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
