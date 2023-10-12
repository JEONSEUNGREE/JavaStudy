package hello.advanced.template;


import hello.advanced.template.code.AbstractTemplate;
import hello.advanced.template.code.SubClassLogic1;
import hello.advanced.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate abstractTemplate1 = new SubClassLogic1();
        AbstractTemplate abstractTemplate2 = new SubClassLogic2();

        abstractTemplate1.execute();
        abstractTemplate2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate abstractTemplate1 = new AbstractTemplate() {

            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        log.info("클래스 이름 = {} ", abstractTemplate1.getClass());
        abstractTemplate1.execute();

        AbstractTemplate abstractTemplate2 = new AbstractTemplate() {

            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        log.info("클래스 이름 = {} ", abstractTemplate2.getClass());
        abstractTemplate2.execute();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);
    }
    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);
    }
}
