package cfvbaibai.tbourse.account.service;

import cfvbaibai.tbourse.account.dto.User;
import cfvbaibai.tbourse.account.dao.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public interface UserService {
    List<User> findMultiple();
    User findSingle(int id);
}


@Service
@SuppressWarnings("unused")
class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private ModelMapper mapper;

    public List<User> findMultiple() {
        List<User> result = new ArrayList<>();
        repo.findAll().forEach(u -> result.add(mapper.map(u, User.class)));
        return result;
    }

    public User findSingle(int id) {
        return repo.findById(id).map(u -> mapper.map(u, User.class)).orElse(null);
    }
}
