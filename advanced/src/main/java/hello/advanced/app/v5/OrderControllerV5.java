package hello.advanced.app.v5;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV4;


    private final LogTrace logTrace;

    @GetMapping("/v4/request")
    public String request(String itemId) throws InterruptedException, IllegalAccessException {

        TraceStatus status = null;

        AbstractTemplate<String> template = new AbstractTemplate<String>(logTrace) {
            @Override
            public String call() throws InterruptedException, IllegalAccessException {
                orderServiceV4.orderItem(itemId);
                return "ok";
            }
        };

        return template.execute("OrderController.request()");
    }
}