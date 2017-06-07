package lyj.framework.cms.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
    
    @RequestMapping("login")
    public ModelAndView test() {
        return new ModelAndView("/login/login");
    }
}
