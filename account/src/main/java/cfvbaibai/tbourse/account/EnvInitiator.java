package cfvbaibai.tbourse.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EnvInitiator {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private Environment env;
    private Logger log = LoggerFactory.getLogger(AccountMainApp.class);
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        if (!profiles.contains("dev")) {
            log.info(String.format("Current profiles: %s. Skip DB initialization.", profiles));
            return;
        }
        log.info("Initializing SQL database...");
        String[] sqls = new String[] {
                "CREATE TABLE User (id INT IDENTITY, identity_type INT, identity_number VARCHAR(25), birth_date DATE)",
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
}
