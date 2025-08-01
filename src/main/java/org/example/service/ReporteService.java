package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ReporteService {

    public void obtenerCursosTotalPromedio(EntityManager em) {

        //total de cursos
        TypedQuery<Long> queryTotal = em.createQuery(
                "SELECT COUNT(c) FROM Curso c",
                Long.class
        );
        Long totalCursos = queryTotal.getSingleResult();

        //promedio de créditos
        TypedQuery<Double> queryPromedio = em.createQuery(
                "SELECT AVG(c.creditos) FROM Curso c",
                Double.class
        );
        Double promedioCreditos = queryPromedio.getSingleResult();

        //máximo de créditos
        TypedQuery<Integer> queryMax = em.createQuery(
                "SELECT MAX(c.creditos) FROM Curso c",
                Integer.class
        );
        Integer maxCreditos = queryMax.getSingleResult();

        //mínimo de créditos
        TypedQuery<Integer> queryMin = em.createQuery(
                "SELECT MIN(c.creditos) FROM Curso c",
                Integer.class
        );
        Integer minCreditos = queryMin.getSingleResult();


        System.out.println("Total de cursos: " + totalCursos);
        System.out.println("Promedio de créditos: " + String.format("%.2f", promedioCreditos));
        System.out.println("Créditos máximos: " + maxCreditos);
        System.out.println("Créditos mínimos: " + minCreditos);
    }

    public void buscarCursosMinimoInscri(EntityManager em, int minimoInscripciones) {
        TypedQuery<String> query = em.createQuery(
                "SELECT c.nombre FROM Curso c JOIN c.inscripciones i GROUP BY c.nombre HAVING COUNT(i) >= :minimo ORDER BY c.nombre",
                String.class
        );
        query.setParameter("minimo", (long) minimoInscripciones);

        List<String> nombresCursos = query.getResultList();

        System.out.println("Cursos con al menos " + minimoInscripciones + " inscripciones:");
        if (nombresCursos.isEmpty()) {
            System.out.println("   - No se encontraron cursos con ese mínimo de inscripciones");
        } else {
            for (String nombreCurso : nombresCursos) {
                System.out.println("   - " + nombreCurso);
            }
            System.out.println("Total de cursos encontrados: " + nombresCursos.size());
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

        System.out.println("Estudiantes inscritos en más de " + minimoCursos + " cursos:");

        for (Object[] resultado : resultados) {
            String nombreEstudiante = (String) resultado[0];
            String emailEstudiante = (String) resultado[1];
            Long cantidadCursos = (Long) resultado[2];
            System.out.println("  --Nombre: " + nombreEstudiante + ", --Email: " + emailEstudiante + ", --Cursos inscritos: " + cantidadCursos);
        }
        System.out.println("Total de estudiantes encontrados: " + resultados.size());
    }

}
