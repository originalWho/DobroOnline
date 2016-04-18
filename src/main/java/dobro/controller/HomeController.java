package dobro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Artur on 4/18/16.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Model model){
        return "home";
    }

}
