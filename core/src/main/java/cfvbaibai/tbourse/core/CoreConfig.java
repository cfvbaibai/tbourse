package cfvbaibai.tbourse.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
    private final Calculator calculator;

    public CoreConfig() {
        calculator = new Calculator();
    }

    @Bean(name = "calculator")
    public Calculator getCalculator() {
        return calculator;
    }
}
