package hello.advanced.app.v5.reflect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AInterfaceImpl implements AInterface {

    @Override
    public void call() {
      log.info("Call AInterface");
    }
}
