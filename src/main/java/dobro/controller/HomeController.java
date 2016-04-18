package dobro.controller;

import dobro.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Artur on 4/18/16.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String checkForm(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "home";
        return "home";
    }
}
