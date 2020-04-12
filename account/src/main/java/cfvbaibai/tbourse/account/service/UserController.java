package cfvbaibai.tbourse.account.service;

import cfvbaibai.tbourse.account.dto.User;
import cfvbaibai.tbourse.account.storage.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@SuppressWarnings("unused")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private JdbcTemplate jdbc;
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return service.findSingle(id);
    }
    @GetMapping
    public List<User> getUsers() {
        return service.findMultiple();
    }
}

@Service
class UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private ModelMapper mapper;

    public List<User> findMultiple() {
        return repo.findAll().stream().map(ue -> mapper.map(ue, User.class)).collect(Collectors.toList());
    }

    public User findSingle(int id) {
        return mapper.map(repo.findById(id), User.class);
    }
}