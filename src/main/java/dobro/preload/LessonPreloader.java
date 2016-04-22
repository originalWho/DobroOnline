package dobro.preload;

import dobro.model.Lesson;
import dobro.model.Role;
import dobro.model.Step;
import dobro.model.Word;
import dobro.repository.RoleRepo;
import dobro.service.LessonService;
import dobro.service.StepService;
import dobro.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artur on 4/19/16.
 */
@Component
public class LessonPreloader implements ApplicationListener<ContextRefreshedEvent> {
    private LessonService lessonService;
    private StepService stepService;
    private WordService wordService;
    private RoleRepo roleRepo;

    @Autowired
    public void setRoleRepo(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Autowired
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    @Autowired
    public void setStepService(StepService stepService) {
        this.stepService = stepService;
    }

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createRole("USER");
        createRole("ADMIN");

        Lesson lesson1 = new Lesson();
        lesson1.setEnabled(true);
        lesson1.setPassed(false);
        lesson1.setLessonId("first");
        lessonService.saveLesson(lesson1);

        List<Step> steps = new ArrayList<>();
        Step step1 = new Step();
        step1.setEnabled(true);
        step1.setPassed(false);
        step1.setOwner(lesson1);
        stepService.saveStep(step1);

        List<Word> words = new ArrayList<>();
        Word word = new Word();
        word.setWord("Hello");
        word.setWordId(1);

        steps.add(step1);
        word.setSteps(steps);
        word.setImageUrl("/images/hello.gif");
        words.add(word);
        step1.setWordList(words);
        wordService.saveWord(word);

        Word word1 = new Word();
        word1.setWord("World");
        word1.setWordId(2);
        word1.setSteps(steps);
        word1.setImageUrl("/images/world.jpg");
        words.add(word1);
        wordService.saveWord(word1);

        stepService.saveStep(step1);
        steps.add(step1);
        lesson1.setStepList(steps);
        lessonService.saveLesson(lesson1);
    }

    @Transactional
    private Role createRole(String name) {
        Role role = roleRepo.findByName(name);
        if (role == null){
            role = new Role();
            role.setName(name);
            roleRepo.save(role);
        }
        return role;
    }
}
