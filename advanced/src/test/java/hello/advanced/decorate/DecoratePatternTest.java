package hello.advanced.decorate;


import hello.advanced.app.v5.decorator.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratePatternTest {


    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();

        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(realComponent);

        decoratorPatternClient.execute();
    }

    @Test
    void decoratorConverse() {
        Component realComponent = new RealComponent();

        DecoratorConverse1 decoratorConverse1 = new DecoratorConverse1(realComponent);
        DecoratorConverse2 decoratorConverse2 = new DecoratorConverse2(decoratorConverse1);

        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(decoratorConverse2);

        decoratorPatternClient.execute();
    }
}
