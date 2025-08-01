package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entity.Inscripcion;

import java.time.LocalDate;
import java.util.List;

public class ReporteService {

    public void obtenerInscripcionTotalPromedio(EntityManager em) {

        TypedQuery<Long> queryTotal = em.createQuery(
                "SELECT COUNT(i) FROM Inscripcion i",
                Long.class
        );
        Long totalInscripciones = queryTotal.getSingleResult();

        TypedQuery<Double> queryPromedio = em.createQuery(
                "SELECT AVG(size(c.inscripciones)) FROM Curso c",
                Double.class
        );
        Double promedioInscripciones = queryPromedio.getSingleResult();

        System.out.println("Total de inscripciones: " + totalInscripciones);
        System.out.println("Promedio de inscripciones por curso: " + String.format("%.2f", promedioInscripciones));
    }

    public void buscarCursosMinimoInscri(EntityManager em, int minimoInscripciones) {
        TypedQuery<String> query = em.createQuery(
                "SELECT c.nombre FROM Curso c JOIN c.inscripciones i GROUP BY c.nombre HAVING COUNT(i) >= :minimo ORDER BY c.nombre",
                String.class
        );
        query.setParameter("minimo", (long) minimoInscripciones);

        List<String> nombresCursos = query.getResultList();

            for (String nombreCurso : nombresCursos) {
                System.out.println("   - " + nombreCurso);
            }

    }

    //Dificil
    public void obtenerEstudiantesMasCursos(EntityManager em, int minimoCursos) {

        TypedQuery<Object[]> query = em.createQuery(
                "SELECT e.nombre, e.email,(SELECT COUNT(DISTINCT i.curso) FROM Inscripcion i WHERE i.estudiante = e) FROM Estudiante e "+
                        "WHERE (SELECT COUNT(DISTINCT i.curso) FROM Inscripcion i WHERE i.estudiante = e) > :minimo ORDER BY e.nombre",
                Object[].class
        );
        query.setParameter("minimo", minimoCursos);

        List<Object[]> resultados = query.getResultList();

        for (Object[] resultado : resultados) {
            String nombreEstudiante = (String) resultado[0];
            String emailEstudiante = (String) resultado[1];
            Long cantidadCursos = (Long) resultado[2];
            System.out.println("  --Nombre: " + nombreEstudiante + ", --Email: " + emailEstudiante + ", --Cursos inscritos: " + cantidadCursos);
        }
    }


    public void obtenerCargaAcademicaProfesores(EntityManager em) {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT p.nombre, SUM(c.creditos) FROM Profesor p JOIN p.cursos c GROUP BY p.nombre ORDER BY SUM(c.creditos) DESC",
                Object[].class
        );
        List<Object[]> resultados = query.getResultList();
            for (Object[] resultado : resultados) {
                System.out.println("Profesor: " + resultado[0] + ", Créditos totales: " + resultado[1]);
            }

    }


    public void buscarInscripcionesPorFechasYEstado(EntityManager em, LocalDate fechaInicio, LocalDate fechaFin, Inscripcion.Estado estado) {

        TypedQuery<Inscripcion> query = em.createQuery(
                "SELECT i FROM Inscripcion i LEFT JOIN FETCH i.curso LEFT JOIN FETCH i.estudiante WHERE i.fechaInscripcion BETWEEN :fechaInicio AND :fechaFin " +
                        "AND i.estado = :estado ORDER BY i.fechaInscripcion DESC",
                Inscripcion.class
        );
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        query.setParameter("estado", estado);

        List<Inscripcion> inscripciones = query.getResultList();

            for (Inscripcion insc : inscripciones) {
                System.out.println("   - Estudiante: " + insc.getEstudiante().getNombre() +
                        ", Curso: " + insc.getCurso().getNombre() +
                        ", Fecha: " + insc.getFechaInscripcion());
            }
    }

    public void buscarInscripcionesPorEstudiante(EntityManager em, String nombreEstudiante) {
        TypedQuery<Inscripcion> query = em.createQuery(
                "SELECT i FROM Inscripcion i LEFT JOIN FETCH i.curso c LEFT JOIN FETCH i.estudiante e WHERE LOWER(e.nombre) LIKE LOWER(:nombreEst) ORDER BY i.fechaInscripcion DESC",
                Inscripcion.class
        );
        query.setParameter("nombreEst",nombreEstudiante );

        List<Inscripcion> inscripciones = query.getResultList();

        System.out.println("Inscripciones del estudiante " + nombreEstudiante + ":");
        if (inscripciones.isEmpty()) {
            System.out.println("   - No hay inscripciones para este estudiante");
        } else {
            for (Inscripcion insc : inscripciones) {
                System.out.println("   - Curso: " + insc.getCurso().getNombre() +
                        " (" + insc.getCurso().getCodigo() + ")" +
                        " - Estado: " + insc.getEstado() +
                        " - Fecha: " + insc.getFechaInscripcion());
            }
        }
    }

    public void buscarInscripcionesPorCodigo(EntityManager em, String codigoCurso) {

        TypedQuery<Inscripcion> query = em.createQuery(
                "SELECT i FROM Inscripcion i LEFT JOIN FETCH i.curso c LEFT JOIN FETCH i.estudiante e WHERE LOWER(c.codigo) LIKE LOWER(:codigoCurso) ORDER BY i.fechaInscripcion DESC",
                Inscripcion.class
        );
        query.setParameter("codigoCurso",codigoCurso );

        List<Inscripcion> inscripciones = query.getResultList();

        System.out.println("Inscripciones para cursos con código " + codigoCurso + ":");
        if (inscripciones.isEmpty()) {
            System.out.println("   - No hay inscripciones para cursos con este código");
        } else {
            for (Inscripcion insc : inscripciones) {
                System.out.println("   - Estudiante: " + insc.getEstudiante().getNombre()+
                        ", Curso: " + insc.getCurso().getNombre() +
                        " (" + insc.getCurso().getCodigo() + ")" +
                        ", Fecha: " + insc.getFechaInscripcion() +
                        ", Estado: " + insc.getEstado());
            }
        }
    }




}




