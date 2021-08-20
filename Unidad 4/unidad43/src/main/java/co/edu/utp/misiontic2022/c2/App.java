package co.edu.utp.misiontic2022.c2;

import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Inicio...");

        disableLogging();

        //createPersona();
        //mostrarFind();
        //removePersona();
        consultaJPQL();

    }

    public static void disableLogging() {
        System.out.println("disableLogging....");
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE);
    }

    public static void createPersona() {
        System.out.println("createPersona....");
        Persona persona = new Persona("Andres", 28);
        Persona persona2 = new Persona("felipe", 30);
        Persona persona3 = new Persona("Juan", 55);


        var emf = Persistence.createEntityManagerFactory("clase12-pu");
        var em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(persona);
            em.persist(persona2);
            em.persist(persona3);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void mostrarFind() {
        System.out.println("MostrarFind....");
        var emf = Persistence.createEntityManagerFactory("clase12-pu");
        var em = emf.createEntityManager();

        try {
            var persona = em.find(Persona.class, "Andres");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Edad: " + persona.getEdad());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removePersona() {
        System.out.println("removePersona...");
        var emf = Persistence.createEntityManagerFactory("clase12-pu");
        var em = emf.createEntityManager();

        try {
            var persona = em.find(Persona.class, "Juan");
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void consultaJPQL() {
        System.out.println("consultaJPQL");
        var emf = Persistence.createEntityManagerFactory("clase12-pu");
        var em = emf.createEntityManager();
        try {
            var query = em.createQuery("SELECT p FROM Persona p ", Persona.class);
            var persona = query.getResultList();
            persona.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
