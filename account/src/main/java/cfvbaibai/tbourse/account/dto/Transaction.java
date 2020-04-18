package cfvbaibai.tbourse.account.dto;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@SuppressWarnings("unused")
@TableName(value = "Tran")
public class Transaction {
    private Integer id;
    private int cardId;
    private LocalDateTime utcTime;
    private String opponent;
    private BigDecimal amount;
    private String memo;

    protected Transaction() {}

    public Transaction(Integer id, int cardId, LocalDateTime utcTime, String opponent, BigDecimal amount, String memo) {
        this.id = id;
        this.cardId = cardId;
        this.utcTime = utcTime;
        this.opponent = opponent;
        this.amount = amount;
        this.memo = memo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public LocalDateTime getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(LocalDateTime utcTime) {
        this.utcTime = utcTime;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Transaction.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("cardId=" + cardId)
                .add("utcTime=" + utcTime)
                .add("opponent='" + opponent + "'")
                .add("amount=" + amount)
                .add("memo='" + memo + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return cardId == that.cardId &&
                id.equals(that.id) &&
                Objects.equals(utcTime, that.utcTime) &&
                Objects.equals(opponent, that.opponent) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(memo, that.memo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardId, utcTime, opponent, amount, memo);
    }
}
