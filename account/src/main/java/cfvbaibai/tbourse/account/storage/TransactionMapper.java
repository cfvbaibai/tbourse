package cfvbaibai.tbourse.account.storage;

import cfvbaibai.tbourse.account.dto.AccountTransactionStat;
import cfvbaibai.tbourse.account.dto.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@SuppressWarnings("unused")
public interface TransactionMapper {
    @Select("SELECT id, card_id, utc_time, opponent, amount, memo FROM Tran WHERE card_id = #{cardId}")
    List<Transaction> findByCardId(int cardId);

    @Select("SELECT a.id AS accountId, COUNT(*) AS transactionCount " +
            "FROM Tran AS t " +
            "LEFT JOIN Card AS c ON t.card_id = c.id " +
            "LEFT JOIN Account AS a ON c.account_id = a.id " +
            "WHERE a.user_id = #{userId} " +
            "GROUP BY a.id")
    List<AccountTransactionStat> summarizeAccountTransaction(int userId);
}
