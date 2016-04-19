package dobro.preload;

import dobro.model.Lesson;
import dobro.model.Step;
import dobro.model.Word;
import dobro.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artur on 4/19/16.
 */
@Component
public class LessonPreloader implements ApplicationListener<ContextRefreshedEvent> {
    private LessonService lessonService;

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Lesson lesson1 = new Lesson();
        lesson1.setEnabled(true);
        lesson1.setPassed(false);
        lesson1.setLessonId("first");

        List<Step> steps = new ArrayList<>();
        Step step1 = new Step();
        step1.setEnabled(true);
        step1.setPassed(false);
        step1.setOwner(lesson1);

        List<Word> words = new ArrayList<>();
        Word word = new Word();
        word.setSteps(steps);
        word.setWord("Hello");
        word.setWordId(1);

        step1.setWordList(words);
        lesson1.setStepList(steps);

        lessonService.saveLesson(lesson1);
    }
}
