package dobro.service;

import dobro.model.Lesson;

/**
 * Created by Artur on 4/18/16.
 */
public interface LessonService {
    Iterable<Lesson> getAllLessons();

    Lesson getLessonById(Integer id);

    void saveLesson(Lesson lesson);

    void deleteLessonById(Integer id);

    void deleteLesson(Lesson lesson);

    void deleteAllLessons();
}
