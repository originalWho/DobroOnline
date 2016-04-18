package repo;

import model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artur on 4/18/16.
 */
public interface LessonRepo extends JpaRepository<Lesson, Integer> {
}
