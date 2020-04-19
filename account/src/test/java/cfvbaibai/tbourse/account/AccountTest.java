package cfvbaibai.tbourse.account;

import cfvbaibai.tbourse.account.dto.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SuppressWarnings("unused")
public class AccountTest extends TbourseWebTest {
    @Test
    public void testGetAccount() {
        Account actualAccount = getForEntity("accounts/1", Account.class);
        Account expectedAccount = new Account(1, 1, "Main");
        assertEquals(expectedAccount, actualAccount);
    }
}
