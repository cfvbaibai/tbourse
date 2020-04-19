package cfvbaibai.tbourse.account;

import cfvbaibai.tbourse.account.dto.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SuppressWarnings("unused")
public class UserTest extends TbourseWebTest {
    @Test
    public void testGetUser() {
        User actual = getForEntity("users/1", User.class);
        User expected = new User(1, 0, "310109198310211017", LocalDate.parse("1983-10-21"));
        assertEquals(expected, actual);
    }
}
