package cfvbaibai.tbourse.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("cfvbaibai.tbourse")
public class AccountMainApp {
    public static void main(String[] args) {
        SpringApplication.run(AccountMainApp.class, args);
    }
}