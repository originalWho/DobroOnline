package dobro.controller;

import dobro.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "dashboard";
    }
}
