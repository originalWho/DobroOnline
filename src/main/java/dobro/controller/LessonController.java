package dobro.controller;

import dobro.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by Artur on 4/18/16.
 */
@Controller
public class LessonController {
    private LessonService lessonService;

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Principal principal, Model model) {
        String name = principal.getName();
        model.addAttribute("name", name);
        model.addAttribute("lessons", lessonService.getAllLessons());
        return "dashboard";
    }

    @RequestMapping("/lesson/{id}")
    public String showLesson(@PathVariable Integer id, Model model) {
        model.addAttribute("words", lessonService.getLessonById(id).getStepList().get(0).getWordList());
        model.addAttribute("size", lessonService.getLessonById(id).getStepList().size());
        model.addAttribute("steps", lessonService.getLessonById(id).getStepList());
        return "lesson";
    }
}
