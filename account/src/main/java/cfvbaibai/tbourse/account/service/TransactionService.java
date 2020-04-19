package cfvbaibai.tbourse.account.service;

import cfvbaibai.tbourse.account.dao.TransactionEntity;
import cfvbaibai.tbourse.account.dao.TransactionMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


public interface TransactionService extends IService<TransactionEntity> {
    TransactionMapper getBaseMapper();
}

@Service
@SuppressWarnings("unused")
class TransactionServiceImpl extends ServiceImpl<TransactionMapper, TransactionEntity> implements TransactionService {
}