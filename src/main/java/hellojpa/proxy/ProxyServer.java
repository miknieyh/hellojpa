package hellojpa.proxy;

import hellojpa.entity.Member;

public class ProxyServer implements Selector{

    private final Selector selector;

    public ProxyServer(Selector selector) {
        this.selector = selector;
    }

    @Override
    public Member select() {
        return selector.select();
    }
}
