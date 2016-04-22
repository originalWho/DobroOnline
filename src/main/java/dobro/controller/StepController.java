package dobro.controller;

import dobro.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Artur on 4/20/16.
 */
@Controller
@RequestMapping("/lesson/**/step")
public class StepController {
    private StepService stepService;

    @Autowired
    public void setStepService(StepService stepService) {
        this.stepService = stepService;
    }

    @RequestMapping("/{id}")
    public String showStep(@PathVariable Integer id, Model model) {
        model.addAttribute("stepId", id);
        model.addAttribute("words", stepService.getStepById(id).getWordList());
        return "stepword";
    }
}
