package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.model.MyUserDetails;
import zw.co.afrosoft.model.User;
import zw.co.afrosoft.persistence.UserRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = repo.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+ userName));

        return user.map(MyUserDetails::new).get();
    }
}
