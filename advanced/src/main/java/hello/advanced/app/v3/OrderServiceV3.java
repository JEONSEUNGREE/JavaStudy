package hello.advanced.app.v3;


import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;

    private final LogTrace logTrace;

    public void orderItem(TraceId traceId, String itemId) throws InterruptedException, IllegalAccessException {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderServiceV3.service()");

            orderRepository.save(status.getTraceId(), itemId);

            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);

            throw e;
        }
    }
}
