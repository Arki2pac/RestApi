package pl.apilia.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.apilia.library.model.Role;
import pl.apilia.library.model.User;
import pl.apilia.library.service.UserServiceImpl;
import pl.apilia.library.web.wrapper.RegistrationWrapper;

/**
 * Created by Grzegorz on 2016-04-19.
 */
@RestController
public class RegistrationController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody RegistrationWrapper registrartionWrapper) {
        User user = registrartionWrapper.extractUser();
        user.setRole(Role.USER);
        userServiceImpl.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}