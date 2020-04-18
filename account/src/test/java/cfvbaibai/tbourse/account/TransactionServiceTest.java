package cfvbaibai.tbourse.account;

import cfvbaibai.tbourse.account.dto.AccountTransactionStat;
import cfvbaibai.tbourse.account.dto.Transaction;
import cfvbaibai.tbourse.account.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TransactionServiceTest extends TbourseTest {
    @Autowired
    private TransactionService svc;

    private static Logger log = LoggerFactory.getLogger(TransactionServiceTest.class);

    @Test
    public void getTranTest() {
        Transaction actual = svc.getById(1);
        Transaction expected = new Transaction(
                1, 1, LocalDateTime.parse("2020-03-10T15:05:00"), "Microsoft",
                BigDecimal.valueOf(5.0), "Azure monthly charge");
        assertEquals(expected, actual);
    }

    @Test
    public void summaryTranTest() {
        List<AccountTransactionStat> actual = svc.getBaseMapper().summarizeAccountTransaction(1);
        List<AccountTransactionStat> expected = Arrays.asList(
            new AccountTransactionStat(1, 2),
            new AccountTransactionStat(2, 1)
        );
        assertIterableEquals(expected, actual);
    }
}
