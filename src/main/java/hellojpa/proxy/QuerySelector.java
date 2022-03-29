package hellojpa.proxy;

import hellojpa.entity.Member;

public class QuerySelector implements Selector{
    Member member = new Member();


    @Override
    public Member select() {
        member.setId(100L);
        member.setName("안녕하세요");
        return member;
    }
}
