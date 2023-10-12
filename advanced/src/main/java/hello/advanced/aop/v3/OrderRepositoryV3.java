package hello.advanced.aop.v2;


import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 traceV2;

    public void save(TraceId traceId, String itemId) throws IllegalAccessException, InterruptedException {

        TraceStatus status = null;

        try {
            status = traceV2.beginSync(traceId, "OrderRepositoryV2.request()");

            if (itemId.equals("ex")) {
                throw new IllegalAccessException("예외 발생!");
            }

            sleep(1000);

            traceV2.end(status);
        } catch (Exception e) {
            traceV2.exception(status, e);

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
