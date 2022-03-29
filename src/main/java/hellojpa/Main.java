package hellojpa;

import hellojpa.proxy.Code;
import hellojpa.proxy.ProxySelector;
import hellojpa.proxy.QuerySelector;
import hellojpa.proxy.Selector;

public class Main {
    public static void main(String[] args) {

        Selector selector = new ProxySelector(new QuerySelector(), Code.LAZY);

        selector.select();


    }
}
