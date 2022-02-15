package popytka_sozdaniya.training100500.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import popytka_sozdaniya.training100500.repos.UserRepos;

@Service
public class UserService implements UserDetailsService {
@Autowired
private UserRepos userRepos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepos.findByUsername(username);
    }
}
