package pl.apilia.library.model;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Grzegorz on 2016-04-20.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

        private User user;

        public CurrentUser(User user) {
            super(user.getLogin(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
            this.user = user;
        }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public String getRole() {
        return user.getRole();
    }

}
