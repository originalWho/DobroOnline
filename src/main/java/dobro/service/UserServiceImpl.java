package dobro.service;

import dobro.model.Role;
import dobro.model.User;
import dobro.repository.RoleRepo;
import dobro.repository.UserRepo;
import dobro.validation.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Artur on 4/18/16.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder encoder;

    @Autowired
    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
    public void setRoleRepo(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void deleteAllUsers() {
        userRepo.deleteAll();
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public void saveUser(User user) throws EmailExistsException {
        if (emailExists(user.getEmail()))
            throw new EmailExistsException("There is an account with that address: " + user.getEmail());
        user.setPassword(encoder.encode(user.getPassword()));
        Role role = roleRepo.findByName("USER");
        user.setRoles(Arrays.asList(role));
        for (Role rolem : user.getRoles())
            System.out.println(rolem.getName());
        userRepo.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepo.delete(id);
    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public boolean emailExists(String email) {
        User user = userRepo.findByEmail(email);
        if (user == null)
            return false;
        return true;
    }
}
