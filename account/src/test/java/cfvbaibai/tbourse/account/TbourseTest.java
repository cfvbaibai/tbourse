package cfvbaibai.tbourse.account;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TbourseTest {

    private static Logger log = LoggerFactory.getLogger(TbourseTest.class);
    private static boolean globalDbInitialized = false;

    @Autowired
    private DataSource ds;

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
                new ClassPathResource("schema-dbinit.sql"),
                new ClassPathResource("data-dbinit.sql")
        );
        DatabasePopulatorUtils.execute(dp, ds);
        globalDbInitialized = true;
        log.info("Global database initialization... [ OK ]");
    }
}
