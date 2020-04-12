package cfvbaibai.tbourse.account.dto;
import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;

@SuppressWarnings("unused")
public class Card {

    public static class Type {
        public static final int DEBIT = 0;
        public static final int CREDIT = 1;
    }

    private Integer id;
    private int accountId;
    private String number;
    private int cardType;
    private BigDecimal balance;
    private JsonNode properties;

    public Card(int uuid, int accountId, String number,
                int cardType, BigDecimal balance, JsonNode properties) {
        this.id = uuid;
        this.accountId = accountId;
        this.number = number;
        this.cardType = cardType;
        this.balance = balance;
        this.properties = properties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }
}
