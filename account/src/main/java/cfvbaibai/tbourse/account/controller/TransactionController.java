package cfvbaibai.tbourse.account.controller;

import cfvbaibai.tbourse.account.dto.AccountTransactionStat;
import cfvbaibai.tbourse.account.dao.TransactionEntity;
import cfvbaibai.tbourse.account.dto.Transaction;
import cfvbaibai.tbourse.account.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
@SuppressWarnings("unused")
public class TransactionController {
    @Autowired
    private TransactionService svc;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public List<Transaction> findByCardId(@RequestParam int cardId) {
        List<TransactionEntity> entities = svc.listByMap(new HashMap<String, Object>() {{put("cardId", cardId);}});
        return entities.stream().map(t -> mapper.map(t, Transaction.class)).collect(Collectors.toList());
    }

    @PutMapping
    public void addTransaction(@RequestBody Transaction transaction) {
        svc.save(mapper.map(transaction, TransactionEntity.class));
    }

    @GetMapping("/stat")
    public List<AccountTransactionStat> summarizeAccountTransaction(@RequestParam int userId) {
        return svc.getBaseMapper().summarizeAccountTransaction(userId);
    }
}
