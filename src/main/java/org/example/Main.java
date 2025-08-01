package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.service.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Academico");
        EntityManager em = emf.createEntityManager();

        CursoService cursoService = new CursoService();
        ProfesorService profesorService = new ProfesorService();
        EstudianteService estudianteService = new EstudianteService();
        InscripcionService inscripcionService = new InscripcionService();

        //Crear 15 registros de Profesor
        profesorService.crearProfesoresPrueba(em);

        //Crear 15 registros de Curso
        cursoService.crearCursoPrueba(em);

        //Crear 15 registros de Estudiante
        estudianteService.crearEstudiantePrueba(em);

        //Asociar Profesores con Curso
        profesorService.asociarProfesoresACursos(em);

        //Asociar Estudiantes con Cursos
        inscripcionService.crearInscripcionesPrueba(em);


        ReporteService reporteService = new ReporteService();

        //A

        System.out.println("----A1---");
        reporteService.obtenerCursosTotalPromedio(em);

        System.out.println("----A2---");
        reporteService.buscarCursosMinimoInscri(em,2);

        //B
        System.out.println("----B2---");
        reporteService.obtenerEstudiantesMasCursos(em,2);


        em.close();
        emf.close();

    }
}