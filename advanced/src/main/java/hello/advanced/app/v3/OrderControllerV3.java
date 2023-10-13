package hello.advanced.app.v3;


import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderServiceV2;


    private final LogTrace logTrace;

    @GetMapping("/v3/request")
    public String request(String itemId) throws InterruptedException, IllegalAccessException {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderControllerV3.request()");

            orderServiceV2.orderItem(status.getTraceId(), itemId);

            logTrace.end(status);

            return "ok";
        } catch (Exception e) {
            logTrace.exception(status, e);

            throw e;
        }
    }
}
