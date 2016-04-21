package pl.apilia.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.apilia.library.db.UserRepository;
import pl.apilia.library.model.User;

import java.util.List;

/**
 * Created by Grzegorz on 2016-04-19.
 */
@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public User findById(long id){
        return userRepository.findOne(id);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public User findById(Long id){
        return userRepository.getOne(id);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
