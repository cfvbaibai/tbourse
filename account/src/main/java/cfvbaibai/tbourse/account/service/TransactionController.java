package cfvbaibai.tbourse.account.service;

import cfvbaibai.tbourse.account.dto.AccountTransactionStat;
import cfvbaibai.tbourse.account.dto.Transaction;
import cfvbaibai.tbourse.account.storage.TransactionMapper;
import cfvbaibai.tbourse.account.storage.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@SuppressWarnings("unused")
public class TransactionController {
    @Autowired
    private TransactionMapper mapper;
    @Autowired
    private TransactionRepository repo;

    @GetMapping
    public List<Transaction> findByCardId(@RequestParam int cardId) {
        return repo.findByCardId(cardId);
    }

    @PutMapping
    public void addTransaction(@RequestBody Transaction transaction) {
        repo.save(transaction);
    }

    @GetMapping("/stat")
    public List<AccountTransactionStat> summarizeAccountTransaction(@RequestParam int userId) {
        return mapper.summarizeAccountTransaction(userId);
    }
}
