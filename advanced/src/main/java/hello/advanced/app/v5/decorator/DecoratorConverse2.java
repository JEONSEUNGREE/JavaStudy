package hello.advanced.app.v5.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorConverse2 implements Component {

    private Component traget;

    public DecoratorConverse2(Component traget) {
        this.traget = traget;
    }


    @Override
    public String operation() {

        log.info("second Decorator");

        String targetResult = traget.operation();

        return "(((((((((" + targetResult + "))))))))";
    }
}
