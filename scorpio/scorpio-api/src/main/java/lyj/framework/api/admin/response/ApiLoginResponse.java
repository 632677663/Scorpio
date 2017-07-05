package lyj.framework.api.admin.response;

import java.io.Serializable;
import java.util.Date;
/**
 * 
* @ClassName: ApiLoginResponse 
* @Description: 用户登录接口返回
* @author lyj 
* @date 2017年7月5日 下午2:06:31
 */
public class ApiLoginResponse extends BaseReponse implements Serializable{
    
    /** 
    * @Fields serialVersionUID :
    */
    private static final long serialVersionUID = -721703144384003501L;
   
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
