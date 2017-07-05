package lyj.framework.api.admin.request;

import java.io.Serializable;

public class ApiLoginRequest extends BaseRequest implements Serializable{

    /** 
    * @Fields serialVersionUID : 
    */
    private static final long serialVersionUID = 8324389511452617886L;
    
    //登录名
    private String loginName;
    //登陆密码
    private String loginPwd;
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
    
}
