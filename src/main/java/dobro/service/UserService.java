package dobro.service;

import dobro.model.User;

/**
 * Created by Artur on 4/18/16.
 */
public interface UserService {
    Iterable<User> getAllUsers();

    User getUserById(Integer id);

    void saveUser(User user);

    void deleteUserById(Integer id);

    void deleteUser(User user);

    void deleteAllUsers();
}
