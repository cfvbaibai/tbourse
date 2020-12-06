package cfvbaibai.tbourse.account.dto;

import java.util.Objects;
import java.util.StringJoiner;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", AccountTransactionStat.class.getSimpleName() + "[", "]")
                .add("accountId=" + accountId)
                .add("transactionCount=" + transactionCount)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionStat that = (AccountTransactionStat) o;
        return accountId == that.accountId &&
                transactionCount == that.transactionCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, transactionCount);
    }
}
