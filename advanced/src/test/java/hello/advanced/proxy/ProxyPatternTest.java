package hello.advanced.proxy;

import hello.advanced.app.v5.proxy.CacheProxy;
import hello.advanced.app.v5.proxy.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void cacheProxyTest() {

        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);

        cacheProxy.operation();
        cacheProxy.operation();
        cacheProxy.operation();
    }
}
