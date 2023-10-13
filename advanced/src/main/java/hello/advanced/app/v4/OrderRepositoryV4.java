package hello.advanced.app.v4;


import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace logTrace;

    public void save(String itemId) throws IllegalAccessException, InterruptedException {

        AbstractTemplate<String> template = new AbstractTemplate<String>(logTrace) {
            @Override
            public String call() throws InterruptedException, IllegalAccessException {
                if (itemId.equals("ex")) {
                    throw new IllegalAccessException("예외 발생!");
                }

                sleep(1000);
                return "ok";
            }
        };

        template.execute("OrderRepositoryV4.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
