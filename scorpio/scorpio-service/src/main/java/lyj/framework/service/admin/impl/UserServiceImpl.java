package lyj.framework.service.admin.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyj.framework.api.admin.request.ApiLoginRequest;
import lyj.framework.api.admin.response.ApiLoginResponse;
import lyj.framework.api.admin.service.IUserService;
import lyj.framework.common.constant.ReturnCode;
import lyj.framework.dao.admin.IUserDao;
import lyj.framework.dao.admin.pojo.LoginVo;
import lyj.framework.exception.admin.AdminExceptionCode;
/**
 * 
* @ClassName: UserServiceImpl 
* @Description: 用户相关操作
* @author lyj 
* @date 2017年7月5日 上午8:39:27
 */
@Service("userServiceAdmin")
public class UserServiceImpl implements IUserService {
    
    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    @Autowired
    private IUserDao userDao;

    @Override
    public ApiLoginResponse login(ApiLoginRequest request) {
        
        if(null == request){
            logger.error("登录入参对象为空");
            ApiLoginResponse response = new ApiLoginResponse();
            response.setReturnCode(AdminExceptionCode.PARAMETER_IS_NULL);
            response.setReturnMessage("参数为空");
            return response;
        }
        
        logger.info("登陆业务,入参:登录名:"+request.getLoginName()+"  登录密码:"+request.getLoginPwd()+"  流水号:"+request.getSerialNo());
        
        if(StringUtils.isBlank(request.getLoginName())){
            logger.error("登录名为空,流水号:"+request.getSerialNo());
            ApiLoginResponse response = new ApiLoginResponse();
            response.setReturnCode(AdminExceptionCode.LOGIN_NAME_IS_NULL);
            response.setReturnMessage("登录名为空");
            return response;
        }
        
        if(StringUtils.isBlank(request.getLoginName())){
            logger.error("密码为空,流水号:"+request.getSerialNo());
            ApiLoginResponse response = new ApiLoginResponse();
            response.setReturnCode(AdminExceptionCode.LOGIN_PWD_IS_NULL);
            response.setReturnMessage("密码为空");
            return response;
        }
        
        
        LoginVo login = new LoginVo();
        
        login.setLoginName(request.getLoginName());
        
        login.setLoginPwd(request.getLoginPwd());
        
        LoginVo info = userDao.findUser(login);
        
        if(null == info){
            logger.error("未查询到登录用户:"+request.getLoginName()+"用户信息,流水号:"+request.getSerialNo());
            ApiLoginResponse response = new ApiLoginResponse();
            response.setReturnCode(AdminExceptionCode.LOGIN_FAIL);
            response.setReturnMessage("账户或密码错误");
            return response;
        }
        
        logger.info("登陆业务完成,流水号:"+request.getSerialNo());
        
        ApiLoginResponse response = new ApiLoginResponse();
        
        response.setLoginName(info.getLoginName());
        response.setLoginPwd(info.getLoginPwd());
        response.setLastLoginTime(info.getLastLoginTime());
        response.setSerialNo(request.getSerialNo());
        response.setReturnCode(ReturnCode.RETURN_SUCCESS);
        response.setReturnMessage("登录成功");
        
        return response;
    }


}
