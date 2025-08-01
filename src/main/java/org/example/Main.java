package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Inscripcion;
import org.example.service.*;

import java.time.LocalDate;

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

        //Crear 15 registros de Curso
        cursoService.crearCursoPrueba(em);

        //Crear 15 registros de Estudiante
        estudianteService.crearEstudiantePrueba(em);

        //Asociar Profesores con Curso
        profesorService.crearProfesores(em);

        //Asociar Estudiantes con Cursos
        inscripcionService.crearInscripcionesPrueba(em);


        ReporteService reporteService = new ReporteService();

        //A

        System.out.println("----A1---");
        reporteService.obtenerInscripcionTotalPromedio(em);

        System.out.println("----A2---");
        System.out.println("Estudiantes con almenos 2 cursos inscritos");
        reporteService.buscarCursosMinimoInscri(em,2);

        //B
        System.out.println("----B---");
        System.out.println("Estudiantes con mas de 2 cursos inscritos");
        reporteService.obtenerEstudiantesMasCursos(em,2);

        //C
        LocalDate fechaInicio = LocalDate.of(2025, 1, 1);
        LocalDate fechaFin = LocalDate.of(2025, 5, 1);
        Inscripcion.Estado estado = Inscripcion.Estado.CONFIRMADA;

        System.out.println("----C1---");
        System.out.println("Inscripciones por fecha y estado");
        reporteService.buscarInscripcionesPorFechasYEstado(em,fechaInicio,fechaFin,estado);

        System.out.println("----C2---");//Incluye fecha de inscripción descendente
        System.out.println("Filtro por Nombre");
        reporteService.buscarInscripcionesPorEstudiante(em,"Joaquin");
        System.out.println("Filtro por Codigo");
        reporteService.buscarInscripcionesPorCodigo(em,"C101");


        //D
        System.out.println("----D1---");
        System.out.println("Suma de creditos totales por Profesor");
        reporteService.obtenerCargaAcademicaProfesores(em);


        em.close();
        emf.close();

    }
}