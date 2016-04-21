package pl.apilia.library.web.wrapper;

import lombok.Data;
import pl.apilia.library.model.User;

/**
 * Created by Grzegorz on 2016-04-19.
 */

@Data
public class RegistrationWrapper {

    private String firstName;
    private String surName;

    private String login;

    private String email;
    private String password;

    private String mobilePhoneNumber;

    public User extractUser(){
        User user = new User();
        user.setFirstName(firstName);
        user.setSurName(surName);
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setMobilePhoneNumber(mobilePhoneNumber);
        return user;
    }

}
