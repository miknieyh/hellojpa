package hellojpa.proxy;

import hellojpa.entity.Member;

public class QuerySelector implements Selector{


    @Override
    public Member select() {
        Member member = new Member();
        member.setId(100L);
        member.setName("안녕하세요");
        return member;
    }
}
