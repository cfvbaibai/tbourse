package cfvbaibai.tbourse.account;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ComponentScan("cfvbaibai.tbourse")
//@ContextConfiguration(classes = {
//        cfvbaibai.tbourse.core.CoreConfig.class,
//        cfvbaibai.tbourse.account.GlobalConfig.class,
//        cfvbaibai.tbourse.account.GlobalConfiguration.class})
@Component
@SuppressWarnings("unused")
public class TbourseTest {

    private static Logger log = LoggerFactory.getLogger(TbourseTest.class);
    private static boolean globalDbInitialized = false;

    @Autowired
    private DataSource ds;

    @Value("${spring.profiles.active}")
    private String profiles;

    @BeforeAll
    private void beforeAll() {
        log.info("Trying to initialize global database...!");
        if (globalDbInitialized) {
            log.info("Global database already initialized. Skip!");
            return;
        }
        ResourceDatabasePopulator dp = new ResourceDatabasePopulator(
                false, false, "utf-8");
        dp.addScripts(
                new ClassPathResource(String.format("schema-%s.sql", profiles)),
                new ClassPathResource(String.format("data-%s.sql", profiles))
        );
        DatabasePopulatorUtils.execute(dp, ds);
        globalDbInitialized = true;
        log.info("Global database initialization... [ OK ]");
    }
}
