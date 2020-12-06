package cfvbaibai.tbourse.account;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest extends TbourseWebTest {
    @Test
    public void testAdd() {
        Integer sum =  getForEntity("calc/add", Integer.class, 10, 20);
        assertEquals(30, sum);
    }
}
