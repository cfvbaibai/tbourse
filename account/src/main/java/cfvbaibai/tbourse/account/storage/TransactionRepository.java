package cfvbaibai.tbourse.account.storage;

import cfvbaibai.tbourse.account.dto.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@SuppressWarnings("unused")
@Mapper
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByCardId(int cardId);
}
