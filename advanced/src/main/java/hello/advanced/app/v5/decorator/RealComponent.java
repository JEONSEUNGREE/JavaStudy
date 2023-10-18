package hello.advanced.app.v5.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {

    @Override
    public String operation() {
        log.info("Real Component");
        return "Flat Data";
    }
}
