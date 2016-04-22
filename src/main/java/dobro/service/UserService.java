package dobro.service;

import dobro.model.User;
import dobro.validation.EmailExistsException;

/**
 * Created by Artur on 4/18/16.
 */
public interface UserService {
    Iterable<User> getAllUsers();

    User getUserById(Integer id);

    void saveUser(User user) throws EmailExistsException;

    void deleteUserById(Integer id);

    void deleteUser(User user);

    void deleteAllUsers();

    boolean emailExists(String email);
}
