package hellojpa.proxy;

import hellojpa.entity.Member;
import hellojpa.factory.CEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProxySelector  implements Selector{

    private final QuerySelector querySelector;
    private final Code code;
    Member member;

    public ProxySelector(QuerySelector querySelector, Code code) {
        this.querySelector = querySelector;
        this.code = code;
    }


    @Override
    public Member select(){
        //Transaction - Begin
        CEntityManagerFactory.initialization();

        EntityManager entityManager = CEntityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction =  entityManager.getTransaction();
        entityTransaction.begin();
        //Transaction - Commit
        try {
            if(Code.LAZY == code){
                System.out.println("Loading만 되었어!");
            }else{
//                Selector selector = ()->{
//                    member.setId(100L);
//                    member.setName("안녕하세요");
//                };
//                selector.select();
                member = this.querySelector.select();
            }
            entityManager.persist(member);
            entityTransaction.commit();
        }
        //Transaction - Rollback
        catch (Exception e) {
            entityTransaction.rollback();
        }
        //Transaction - Close
        finally {
            entityManager.close();
        }
        CEntityManagerFactory.close();

        return null;
    }

}
