package dobro.controller;

import dobro.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showStep(@PathVariable Integer id, Model model) {
        model.addAttribute("stepId", id);
        model.addAttribute("wordStrings", stepService.getStepById(id).getStrings());
        model.addAttribute("words", stepService.getStepById(id).getWordList());
        return "stepword";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String nextStep(@PathVariable Integer id, Model model) {
        try {
            stepService.getStepById(id).setPassed(true);
        } catch (Exception e) {
            stepService.getStepById(id-1).setPassed(true);
            stepService.getStepById(id-1).getOwner().setPassed(true);
            return "redirect:/dashboard";
        }
        return "stepword";
    }
}
