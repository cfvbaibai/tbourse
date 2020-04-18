package cfvbaibai.tbourse.account.service;

import cfvbaibai.tbourse.account.dto.AccountTransactionStat;
import cfvbaibai.tbourse.account.dto.Transaction;
import cfvbaibai.tbourse.account.storage.TransactionMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@SuppressWarnings("unused")
public class TransactionController {
    @Autowired
    private TransactionService svc;

    @GetMapping
    public List<Transaction> findByCardId(@RequestParam int cardId) {
        return svc.listByMap(new HashMap<String, Object>() {{put("cardId", cardId);}});
    }

    @PutMapping
    public void addTransaction(@RequestBody Transaction transaction) {
        svc.save(transaction);
    }

    @GetMapping("/stat")
    public List<AccountTransactionStat> summarizeAccountTransaction(@RequestParam int userId) {
        return svc.getBaseMapper().summarizeAccountTransaction(userId);
    }
}
