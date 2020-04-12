package cfvbaibai.tbourse.account.service;

import cfvbaibai.tbourse.account.dto.AccountTransactionStat;
import cfvbaibai.tbourse.account.dto.Transaction;
import cfvbaibai.tbourse.account.storage.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@SuppressWarnings("unused")
public class TransactionController {
    @Autowired
    private TransactionMapper mapper;
    @GetMapping
    public List<Transaction> findByCardId(@RequestParam int cardId) {
        return mapper.findByCardId(cardId);
    }

    @GetMapping("/stat")
    public List<AccountTransactionStat> summarizeAccountTransaction(@RequestParam int userId) {
        return mapper.summarizeAccountTransaction(userId);
    }
}
