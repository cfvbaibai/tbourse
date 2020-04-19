package cfvbaibai.tbourse.account.controller;

import cfvbaibai.tbourse.account.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    public JdbcTemplate jdbc;

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id) {
        String sql = "SELECT * FROM Account WHERE id = ?";
        @SuppressWarnings("UnnecessaryLocalVariable")
        Account account = jdbc
                .query(
                    sql, new Object[] { id },
                    (rs, n) -> new Account(id, rs.getInt("user_id"), rs.getString("name")))
                .stream().findFirst().orElse(null);
        return account;
    }

    @PutMapping()
    public void addAccount(@RequestBody Account account) {
        if (account.getId() != null) {
            throw new IllegalArgumentException(("account.id must be null!"));
        }
        String sql = "INSERT INTO Account (userId, name) VALUES (?, ?)";
        jdbc.update(sql, account.getUserId(), account.getName());
    }
}