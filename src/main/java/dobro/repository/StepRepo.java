package dobro.repository;

import dobro.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artur on 4/19/16.
 */
public interface StepRepo extends JpaRepository<Step, Integer> {
}
