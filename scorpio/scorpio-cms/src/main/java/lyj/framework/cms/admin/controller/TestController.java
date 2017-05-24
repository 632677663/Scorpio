package lyj.framework.cms.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lyj.framework.api.admin.response.TestResponse;
import lyj.framework.api.admin.service.TestService;

@Controller
@RequestMapping("api/")
public class TestController {
    
    @Autowired
    private TestService testService;
    
    @RequestMapping("test")
    public ModelAndView test(){
        
        TestResponse vo = testService.findTest("7");
        
        System.out.println(vo.getNo());
        
        return null;
    }
    
    
}
