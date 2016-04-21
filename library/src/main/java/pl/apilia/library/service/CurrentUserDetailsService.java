package pl.apilia.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.apilia.library.db.UserRepository;
import pl.apilia.library.model.CurrentUser;
import pl.apilia.library.model.User;

/**
 * Created by Grzegorz on 2016-04-20.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CurrentUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByLogin(username);

        if(user == null){
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        return new CurrentUser(user);
    }


}
