package cfvbaibai.tbourse.account.services;

import cfvbaibai.tbourse.account.beans.Card;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cards")
@SuppressWarnings("unused")
public class CardController {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private ObjectMapper mapper;

    @GetMapping()
    public List<Card> getCards(
            @RequestParam(value = "accountId") int accountId) {
        return jdbc.query("SELECT * FROM Card WHERE accountId = ?",
                new Object[]{accountId}, (rs, n) ->
                {
                    try {
                        return new Card(
                                rs.getInt("id"),
                                rs.getInt("accountId"),
                                rs.getString("number"),
                                rs.getInt("cardType"),
                                rs.getBigDecimal("balance"),
                                mapper.readTree(rs.getString("properties"))
                        );
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
