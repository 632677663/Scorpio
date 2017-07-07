package lyj.framework.cms.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lyj.framework.api.admin.request.ApiLoginRequest;
import lyj.framework.api.admin.response.ApiLoginResponse;
import lyj.framework.api.admin.service.IUserService;
import lyj.framework.cms.admin.bean.Login;
import lyj.framework.cms.admin.constant.AdminConstant;
import lyj.framework.common.constant.ReturnCode;
import lyj.framework.util.SerialNoUtil;
import lyj.framework.util.VerifyCodeUtil;

@Controller
@RequestMapping("/")
public class LoginController {
    
    
    private Logger logger = Logger.getLogger(LoginController.class);
    
    @Autowired
    private IUserService userServiceAdmin;
    
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
        
        code.getRandCode(request, response, AdminConstant.KEY_VERIFY_CODE);
        
        logger.info("===验证码业务结束===");
        
    }
    
    
    @RequestMapping("toLogin")
    public ModelAndView toLogin(Login login,String code,HttpServletRequest request,HttpServletResponse response){
        logger.info("===登录业务开始===");
        //验证码判断
        if(StringUtils.isBlank(code)){
            logger.error("验证码不能为空");
        }
        //获取session中的验证码
        String random_code = (String) request.getSession().getAttribute(AdminConstant.KEY_VERIFY_CODE);
        
        ModelAndView modelAndView = new ModelAndView();
        
        if(code.equalsIgnoreCase(random_code)){
            ApiLoginRequest apiRequest = new ApiLoginRequest();
            
            apiRequest.setSerialNo(SerialNoUtil.getSerialNo());
            
            apiRequest.setLoginName(login.getName());
            
            apiRequest.setLoginPwd(login.getPassword());
            
            ApiLoginResponse info = userServiceAdmin.login(apiRequest);
            
            if(null == info){
                logger.error("系统异常");
                modelAndView.addObject("message","系统异常");
                return modelAndView;
            }
            
            if(ReturnCode.RETURN_SUCCESS.equals(info.getReturnCode())){
                //登录信息放入session
                request.getSession().setAttribute(AdminConstant.KEY_LOGIN_INFO, info);
                //TODO 跳转正确页面
                return null;
            }else{
                logger.error(info.getReturnMessage());
                modelAndView.addObject("message",info.getReturnMessage());
                modelAndView.addObject("name",login.getName());
                modelAndView.addObject("password",login.getName());
                modelAndView.setViewName("/login/login");
                return modelAndView;
            }
           
        }else{
            logger.error("验证码错误");
            modelAndView.addObject("message","验证码错误");
            return  modelAndView;
        }
        
        
    }
    
    
    
}
