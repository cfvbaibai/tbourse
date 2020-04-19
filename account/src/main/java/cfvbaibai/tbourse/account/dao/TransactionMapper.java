package cfvbaibai.tbourse.account.dao;

import cfvbaibai.tbourse.account.dto.AccountTransactionStat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@SuppressWarnings("unused")
public interface TransactionMapper extends BaseMapper<TransactionEntity> {
    @Select("SELECT a.id AS accountId, COUNT(*) AS transactionCount " +
            "FROM Tran AS t " +
            "LEFT JOIN Card AS c ON t.card_id = c.id " +
            "LEFT JOIN Account AS a ON c.account_id = a.id " +
            "WHERE a.user_id = #{userId} " +
            "GROUP BY a.id")
    List<AccountTransactionStat> summarizeAccountTransaction(int userId);
}