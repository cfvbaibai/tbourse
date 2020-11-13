package cfvbaibai.tbourse.account.controller;

import cfvbaibai.tbourse.account.dto.User;
import cfvbaibai.tbourse.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return service.findSingle(id);
    }
    @GetMapping
    public List<User> getUsers() {
        return service.findMultiple();
    }
}

