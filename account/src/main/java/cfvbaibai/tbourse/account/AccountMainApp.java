package cfvbaibai.tbourse.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AccountMainApp {
    public static String ping(String s) {
        return s;
    }

    private Logger log = LoggerFactory.getLogger(AccountMainApp.class);

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        if (!profiles.contains("dev")) {
            log.info(String.format("Current profiles: %s. Skip DB initialization.", profiles));
            return;
        }
        String[] sqls = new String[] {
                "CREATE TABLE User (id INT IDENTITY, identityType INT, identityNumber VARCHAR(25), birthDate DATE)",
                "CREATE TABLE Account (id INT IDENTITY, userId INT, name VARCHAR(32))",
                "CREATE TABLE Card (id INT IDENTITY, accountId INT, number VARCHAR(32), " +
                        "cardType INT, balance DECIMAL, properties VARCHAR(256))",
                "INSERT INTO User VALUES (1, 0, '310109198310211017', '1983-10-21')",
                "INSERT INTO Account VALUES (1, 1, 'Main')",
                "INSERT INTO Card VALUES (1, 1, '6203040293848182', 0, 20.0, '{\"ping\": \"99203945\"}')",
                "INSERT INTO Card VALUES (2, 1, '2670203000283821', 0, 30000.0, '{\"expire\": \"202004\"}')",
        };
        jdbc.batchUpdate(sqls);
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountMainApp.class, args);
    }
}