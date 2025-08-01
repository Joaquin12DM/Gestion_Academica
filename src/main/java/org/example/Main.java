package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Curso;
import org.example.entity.Estudiante;
import org.example.entity.Profesor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Academico");
        EntityManager em = emf.createEntityManager();

        Estudiante estudiante = new Estudiante();
        Profesor profesor = new Profesor();
        Curso curso = new Curso();





        em.close();
        emf.close();

    }
}