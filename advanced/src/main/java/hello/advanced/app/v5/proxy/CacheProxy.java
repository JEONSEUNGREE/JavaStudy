package hello.advanced.app.v5.proxy;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

    private Subject target;

    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");

        // 원하는 시점에 프록시 객체를 생성 하며 이미 있는 경우 생성된 타켓을 리턴
        if (cacheValue == null) {
            cacheValue = target.operation();
        }
        return cacheValue;
    }
}
