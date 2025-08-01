package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Estudiante;

import java.util.List;

public class EstudianteService {

    List<Estudiante> estudiantesPrueba = List.of(
            new Estudiante("Joaquin","joaquin@gmail.com","202502"),
            new Estudiante("Wilson","wilson@gmail.com","202502"),
            new Estudiante("Yorky","yorky@gmail.com","202502"),
            new Estudiante("Pilar","pilar@gmail.com","202502"),
            new Estudiante("Pierre","pierre@gmail.com","202502"),
            new Estudiante("Edson","edson@gmail.com","202502"),
            new Estudiante("Francisco","francisco@gmail.com","202502"),
            new Estudiante("Sedano","sedano@gmail.com","202502"),
            new Estudiante("Fanny","fanny@gmail.com","202502"),
            new Estudiante("Cristell","cristell@gmail.com","202502"),
            new Estudiante("Luis","luis@gmail.com","202502"),
            new Estudiante("Claudia","claudia@gmail.com","202502"),
            new Estudiante("Cristian","cristian@gmail.com","202502"),
            new Estudiante("Felix","felix@gmail.com","202502"),
            new Estudiante("Jose","jose@gmail.com","202502")
    );

    public void crearEstudiantePrueba(EntityManager em) {
        crearEstudiantes(em, estudiantesPrueba);
    }


    public void crearEstudiantes(EntityManager em, List<Estudiante> estudiantes) {

        em.getTransaction().begin();

        try {
            for (Estudiante est : estudiantes) {
                em.persist(est);
            }

            em.getTransaction().commit();
            System.out.println("Estudiantes de prueba creados");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al registrar estudiantes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
