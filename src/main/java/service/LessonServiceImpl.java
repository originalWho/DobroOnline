package service;

import org.springframework.beans.factory.annotation.Autowired;
import repo.LessonRepo;

/**
 * Created by Artur on 4/18/16.
 */
public class LessonServiceImpl implements LessonService {
    private LessonRepo lessonRepo;

    @Autowired
    public void setLessonRepo(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }
}
