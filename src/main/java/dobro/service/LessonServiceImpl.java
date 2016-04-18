package dobro.service;

import dobro.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Artur on 4/18/16.
 */
@Service
public class LessonServiceImpl implements LessonService {
    private LessonRepo lessonRepo;

    @Autowired
    public void setLessonRepo(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }
}
