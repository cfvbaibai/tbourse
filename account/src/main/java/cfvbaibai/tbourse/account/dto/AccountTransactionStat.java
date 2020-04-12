package cfvbaibai.tbourse.account.dto;

@SuppressWarnings("unused")
public class AccountTransactionStat {
    private int accountId;
    private int transactionCount;

    public AccountTransactionStat(int accountId, int transactionCount) {
        this.accountId = accountId;
        this.transactionCount = transactionCount;
    }

    protected AccountTransactionStat() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }
}
