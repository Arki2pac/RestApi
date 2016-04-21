package pl.apilia.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.apilia.library.model.CurrentUser;
import pl.apilia.library.model.User;
import pl.apilia.library.service.UserServiceImpl;

import java.security.Principal;

/**
 * Created by Grzegorz on 2016-04-20.
 */
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getCurrentUser(Authentication authentication) {
        User user = userServiceImpl.findById(((CurrentUser) authentication.getPrincipal()).getId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
