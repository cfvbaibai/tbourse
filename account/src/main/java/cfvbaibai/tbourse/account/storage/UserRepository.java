package cfvbaibai.tbourse.account.storage;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findById(int id);
    List<UserEntity> findAll();
}
