package cfvbaibai.tbourse.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountMainAppTest {
    @Test
    public void pingTest() {
        assertEquals("A", AccountMainApp.ping("A"));
    }
}
