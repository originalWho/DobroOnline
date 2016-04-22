package dobro.service;

import dobro.model.Role;
import dobro.model.User;
import dobro.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Artur on 4/19/16.
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepo.findByEmail(email);

        if (user == null){
            System.out.println("User not found");
            return null;
        }
        for (GrantedAuthority authority : getGrantedAuthorities(user.getRoles()))
            System.out.println(authority);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                getGrantedAuthorities(user.getRoles())
        );
    }

    private static Collection<GrantedAuthority> getGrantedAuthorities(Collection<Role> roles) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : roles)
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        return grantedAuthorities;
    }

}
