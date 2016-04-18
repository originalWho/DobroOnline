package dobro.service;

import dobro.model.Lesson;
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

    @Override
    public void deleteAllLessons() {
        lessonRepo.deleteAll();
    }

    @Override
    public Iterable<Lesson> getAllLessons() {
        return lessonRepo.findAll();
    }

    @Override
    public Lesson getLessonById(Integer id) {
        return lessonRepo.findOne(id);
    }

    @Override
    public void saveLesson(Lesson lesson) {
        lessonRepo.save(lesson);
    }

    @Override
    public void deleteLessonById(Integer id) {
        lessonRepo.delete(id);
    }

    @Override
    public void deleteLesson(Lesson lesson) {
        lessonRepo.delete(lesson);
    }
}
