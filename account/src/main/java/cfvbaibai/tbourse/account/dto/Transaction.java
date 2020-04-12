package cfvbaibai.tbourse.account.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("unused")
public class Transaction {
    private int id;
    private int cardId;
    private LocalDate utcTime;
    private String opponent;
    private BigDecimal amount;
    private String memo;

    public Transaction(int id, int cardId, LocalDate utcTime, String opponent, BigDecimal amount, String memo) {
        this.id = id;
        this.cardId = cardId;
        this.utcTime = utcTime;
        this.opponent = opponent;
        this.amount = amount;
        this.memo = memo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public LocalDate getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(LocalDate utcTime) {
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
