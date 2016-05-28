package pl.apilia.library.web;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.apilia.library.exceptions.UserException;
import pl.apilia.library.model.User;
import pl.apilia.library.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Grzegorz on 2016-04-20.
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public ResponseEntity deleteBook(@PathVariable("userId") Long userId) {
        userServiceImpl.delete(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user){
        userServiceImpl.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findUsers(){
        return userServiceImpl.findAll();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User findUsersById(@PathVariable Long userId) throws UserException {
        User user = userServiceImpl.findById(userId);
        if(user == null){
            throw new UserException("404 STATUS NOT FOUND", "Użytkownik o podanym id nie istnieje");
        }
        return user;
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable("userId") Long userId, @RequestBody User user){
        User userToUpdate = userServiceImpl.findById(userId);
        String login = user.getLogin();
        String email = user.getEmail();
        String password = user.getPassword();
        userToUpdate.setEmail(email);
        userToUpdate.setPassword(password);
        userToUpdate.setLogin(login);
        userServiceImpl.save(userToUpdate);
        return new ResponseEntity(HttpStatus.OK);
    }
}
