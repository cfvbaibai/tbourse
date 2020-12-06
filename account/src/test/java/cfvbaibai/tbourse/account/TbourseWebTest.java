package cfvbaibai.tbourse.account;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@EnableAutoConfiguration
@SuppressWarnings("unused")
public class TbourseWebTest extends TbourseTest {
    @LocalServerPort
    private int localPort;

    protected String getUri(String path) {
        return String.format("http://localhost:%s/%s", localPort, path);
    }

    @SuppressWarnings("SameParameterValue")
    protected <T> T getForEntity(String path, Class<T> clazz, Object... variables) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = getUri(path);
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(uri, clazz, variables);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        return responseEntity.getBody();
    }
}
