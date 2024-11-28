package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDBUtil {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("primerabd.odb");
    }

     public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
