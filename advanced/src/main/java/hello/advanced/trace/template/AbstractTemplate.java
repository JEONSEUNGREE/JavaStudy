package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
public abstract class AbstractTemplate<T> {

    private LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public T execute(String message) throws InterruptedException, IllegalAccessException {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);
            // 로직 호출
            T result = call();

            logTrace.end(status);

            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    public abstract T call() throws InterruptedException, IllegalAccessException;

}
