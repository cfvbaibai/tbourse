package cfvbaibai.tbourse.account.services;

import cfvbaibai.tbourse.account.storage.UserEntity;
import cfvbaibai.tbourse.account.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@SuppressWarnings("unused")
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private JdbcTemplate jdbc;
    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return userRepo.findById(id);
    }
    @GetMapping
    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }
}
