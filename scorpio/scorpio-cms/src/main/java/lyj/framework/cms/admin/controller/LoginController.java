package lyj.framework.cms.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lyj.framework.cms.admin.bean.User;
import lyj.framework.util.VerifyCodeUtil;

@Controller
@RequestMapping("/")
public class LoginController {
    
    
    private Logger logger = Logger.getLogger(LoginController.class);
    
    @RequestMapping("login")
    public ModelAndView login() {
        return new ModelAndView("/login/login");
    }
    
    @RequestMapping("getRandomCode")
    @ResponseBody
    public void getRandomCode(HttpServletRequest request,HttpServletResponse response){
        
        logger.info("===验证码业务开始===");
        
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        //生成验证码
        VerifyCodeUtil code = new VerifyCodeUtil();
        
        code.getRandCode(request, response, "userInfo");
        
        logger.info("===验证码业务结束===");
        
    }
    
    
    @RequestMapping("toLogin")
    public ModelAndView toLogin(User user,HttpServletRequest request,HttpServletResponse response){
        logger.info("===登录业务开始===");
        String name = user.getName();
        
        System.out.println(name);
        
        return null;
    }
    
    
    
}
