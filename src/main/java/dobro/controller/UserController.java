package dobro.controller;

import dobro.model.User;
import dobro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Artur on 4/18/16.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(User user){
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkForm(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Form has errors");
            return "home";
        }
        userService.saveUser(user);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Principal principal, Model model) {
        String name = principal.getName();
        model.addAttribute("name", name);
        return "dashboard";
    }

    @RequestMapping(value = "/signin")
    public String signIn() {
        return "signin";
    }
}
