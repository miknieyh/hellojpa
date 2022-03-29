package hellojpa;

import hellojpa.entity.Member;
import hellojpa.factory.CEntityManagerFactory;
import hellojpa.proxy.Code;
import hellojpa.proxy.ProxySelector;
import hellojpa.proxy.QuerySelector;
import hellojpa.proxy.Selector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Selector selector = new ProxySelector(new QuerySelector(), Code.LAZY);

        selector.select();


    }
}
