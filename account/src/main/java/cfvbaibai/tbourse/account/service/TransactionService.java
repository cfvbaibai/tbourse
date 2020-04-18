package cfvbaibai.tbourse.account.service;

import cfvbaibai.tbourse.account.dto.Transaction;
import cfvbaibai.tbourse.account.storage.TransactionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends ServiceImpl<TransactionMapper, Transaction> {
}