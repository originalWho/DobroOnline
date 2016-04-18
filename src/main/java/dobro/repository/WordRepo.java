package dobro.repository;

import dobro.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artur on 4/18/16.
 */
public interface WordRepo extends JpaRepository<Word, Integer> {
}
