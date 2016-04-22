package dobro.controller;

import dobro.service.LessonService;
import dobro.service.UserService;
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
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Principal principal, Model model) {
        String email = principal.getName();
        String name = userService.getUserByEmail(email).getUsername();
        model.addAttribute("name", name);
        model.addAttribute("lessons", lessonService.getAllLessons());
        return "dashboard";
    }

    @RequestMapping("/lesson/{id}")
    public String showLesson(@PathVariable Integer id, Model model) {
        model.addAttribute("lessonId", id);
        model.addAttribute("size", lessonService.getLessonById(id).getStepList().size());
        model.addAttribute("steps", lessonService.getLessonById(id).getStepList());
        return "lesson";
    }
}
