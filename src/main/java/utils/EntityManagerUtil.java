package utils;// package utils;

 import jakarta.persistence.EntityManager;
 import jakarta.persistence.EntityManagerFactory;
 import jakarta.persistence.Persistence;

 public class EntityManagerUtil {
     private static final EntityManagerFactory emf =
             Persistence.createEntityManagerFactory("defaultPU");

     public static EntityManager getEntityManager() {
         return emf.createEntityManager();
     }

     public static void close() {
         if (emf.isOpen()) emf.close();
     }
 }
