package cfvbaibai.tbourse.account.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
@Entity
@Table(name = "Tran")
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
}
