package repo;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artur on 4/18/16.
 */
public interface UserRepo extends JpaRepository<User, Integer> {
}
