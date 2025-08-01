package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Curso;
import org.example.entity.Estudiante;
import org.example.entity.Inscripcion;

import java.time.LocalDate;
import java.util.List;

public class InscripcionService {

    public void crearInscripcionesPrueba(EntityManager em) {

        try {
            em.getTransaction().begin();

            LocalDate fecha = LocalDate.of(2025, 3, 1);
            Inscripcion.Estado estado = Inscripcion.Estado.CONFIRMADA;

            Estudiante estudiante1 = em.find(Estudiante.class, 1L);
            Estudiante estudiante2 = em.find(Estudiante.class, 2L);
            Estudiante estudiante3 = em.find(Estudiante.class, 3L);

            Curso curso1 = em.find(Curso.class, 1L);
            Curso curso2 = em.find(Curso.class, 2L);
            Curso curso3 = em.find(Curso.class, 3L);
            Curso curso4 = em.find(Curso.class, 4L);
            Curso curso5 = em.find(Curso.class, 5L);

            em.persist(new Inscripcion(fecha, curso1, estado, estudiante1));
            em.persist(new Inscripcion(fecha, curso2, estado, estudiante1));
            em.persist(new Inscripcion(fecha, curso3, estado, estudiante1));
            em.persist(new Inscripcion(fecha, curso4, estado, estudiante1));
            em.persist(new Inscripcion(fecha, curso5, estado, estudiante1));
            em.persist(new Inscripcion(fecha, curso1, estado, estudiante2));
            em.persist(new Inscripcion(fecha, curso2, estado, estudiante2));
            em.persist(new Inscripcion(fecha, curso3, estado, estudiante2));
            em.persist(new Inscripcion(fecha, curso4, estado, estudiante2));
            em.persist(new Inscripcion(fecha, curso5, estado, estudiante2));
            em.persist(new Inscripcion(fecha, curso1, estado, estudiante3));
            em.persist(new Inscripcion(fecha, curso2, estado, estudiante3));
            em.persist(new Inscripcion(fecha, curso3, estado, estudiante3));
            em.persist(new Inscripcion(fecha, curso4, estado, estudiante3));
            em.persist(new Inscripcion(fecha, curso5, estado, estudiante3));

            em.getTransaction().commit();
            System.out.println("Se crearon 15 inscripciones");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

}
