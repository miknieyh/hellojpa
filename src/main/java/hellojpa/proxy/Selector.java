package hellojpa.proxy;

import hellojpa.entity.Member;

@FunctionalInterface
public interface Selector {

    Member select();

}
