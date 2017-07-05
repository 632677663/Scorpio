package lyj.framework.dao.admin.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @ClassName: LoginVo 
* @Description: 用户登录信息 
* @author lyj 
* @date 2017年7月5日 上午8:48:20
 */
public class LoginVo implements Serializable{
    
    /** 
    * @Fields serialVersionUID :  
    */
    private static final long serialVersionUID = 5735185050078017853L;
    //登录名
    private String loginName;
    //登陆密码
    private String loginPwd;
    //上次登录时间
    private Date lastLoginTime;
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getLoginPwd() {
        return loginPwd;
    }
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
