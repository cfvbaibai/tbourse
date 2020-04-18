package cfvbaibai.tbourse.account;

import cfvbaibai.tbourse.account.dto.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountTest extends TbourseTest {
    @LocalServerPort
    private int localPort;

    @Test
    public void testGetAccount() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = String.format("http://localhost:%s/accounts/%s", localPort, 1);
        ResponseEntity<Account> accountResponse = restTemplate.getForEntity(uri, Account.class);
        assertEquals(HttpStatus.OK, accountResponse.getStatusCode());
        Account actualAccount = accountResponse.getBody();
        Account expectedAccount = new Account(1, 1, "Main");
        assertEquals(expectedAccount, actualAccount);
    }
}
