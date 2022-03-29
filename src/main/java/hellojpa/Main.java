package hellojpa;

import hellojpa.entity.Member;
import hellojpa.factory.CEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        CEntityManagerFactory.initialization();

        EntityManager entityManager = CEntityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Member member = new Member();
            member.setId(100L);
            member.setName("안녕하세요");

            entityManager.persist(member);
            entityTransaction.commit();
        }catch (Exception e) {
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }
        CEntityManagerFactory.close();
    }
}
