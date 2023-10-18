package hello.advanced.app.v5.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorConverse1 implements Component {

    private Component target;

    public DecoratorConverse1(Component target) {
        this.target = target;
    }

    @Override
    public String operation() {

        log.info("first Decorator");

        String targetResult = target.operation();

        return "**********" + targetResult + "**********";
    }
}
