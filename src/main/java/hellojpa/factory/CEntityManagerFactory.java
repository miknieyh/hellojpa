package hellojpa.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CEntityManagerFactory {

    private static EntityManagerFactory entityManagerFactory;

    public static void initialization(){
        entityManagerFactory =  Persistence.createEntityManagerFactory("hello");
    }

    public static EntityManager createEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        entityManagerFactory.close();
    }
}
