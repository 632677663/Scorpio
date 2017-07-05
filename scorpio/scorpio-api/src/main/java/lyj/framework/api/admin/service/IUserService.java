package lyj.framework.api.admin.service;

import lyj.framework.api.admin.request.ApiLoginRequest;
import lyj.framework.api.admin.response.ApiLoginResponse;

/**
 * 
* @ClassName: IUserService 
* @Description: 用户的一些操作
* @author lyj 
* @date 2017年7月4日 下午4:24:01
 */
public interface IUserService {
    /**
     * 登录操作
     * @param request 请求参数
     * @return 查询到的登录信息
     */
    public ApiLoginResponse login(ApiLoginRequest request);
    
}
