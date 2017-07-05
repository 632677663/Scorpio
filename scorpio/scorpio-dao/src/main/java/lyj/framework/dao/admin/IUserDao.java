package lyj.framework.dao.admin;

import lyj.framework.dao.admin.pojo.LoginVo;

/**
 * 
* @ClassName: UserDao 
* @Description: 用户相关的数据操作
* @author lyj 
* @date 2017年7月5日 上午8:42:24
 */
public interface IUserDao {
    
    /**
     * 根据登录对象查询登录账户是否存在
     * @param login 登录信息
     * @return 登录信息
     */
    public LoginVo findUser(LoginVo login);
    
}
