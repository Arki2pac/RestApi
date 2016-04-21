package pl.apilia.library.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.apilia.library.model.User;

import java.util.List;

/**
 * Created by Grzegorz on 2016-04-19.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByLogin(String login);
}
