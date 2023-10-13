package hello.advanced.app.v3;


import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace logTrace;

    public void save(TraceId traceId, String itemId) throws IllegalAccessException, InterruptedException {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepositoryV3.repository()");

            if (itemId.equals("ex")) {
                throw new IllegalAccessException("예외 발생!");
            }

            sleep(1000);

            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);

            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
