package hello.advanced.app.v4;


import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;

    private final LogTrace logTrace;

    public void orderItem(String itemId) throws InterruptedException, IllegalAccessException {

        TraceStatus status = null;

        AbstractTemplate<String> template = new AbstractTemplate<String>(logTrace) {
            @Override
            public String call() throws InterruptedException, IllegalAccessException {
                orderRepository.save(itemId);
                return "ok";
            }
        };

        template.execute("OrderServiceV4.orderItem()");
    }
}
