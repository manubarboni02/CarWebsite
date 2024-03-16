package SpringBoot.CarWebsite.Service;

import SpringBoot.CarWebsite.Model.SecurityUser;
import SpringBoot.CarWebsite.Model.User;
import SpringBoot.CarWebsite.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("Username not found");
        return new SecurityUser(user);

    }
}
