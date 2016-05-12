package pl.apilia.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/delete/{userId}")
    public ResponseEntity deleteBook(@PathVariable("userId") Long userId) {
        userServiceImpl.delete(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{login}", method = RequestMethod.POST)
    public ResponseEntity addBook(@RequestBody User user){
        userServiceImpl.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findUsers(){
        return userServiceImpl.findAll();
    }
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User findUsersById(@PathVariable Long userId){
        return userServiceImpl.findById(userId);
    }
}
