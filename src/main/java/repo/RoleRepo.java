package repo;

import model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artur on 4/18/16.
 */
public interface RoleRepo extends JpaRepository<Role, Integer> {
}
