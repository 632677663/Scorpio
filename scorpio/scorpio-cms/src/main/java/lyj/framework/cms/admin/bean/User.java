package lyj.framework.cms.admin.bean;

import java.io.Serializable;

public class User implements Serializable {

    /** 
    * @Fields serialVersionUID
    */
    private static final long serialVersionUID = -3011612319729920174L;
    
    private String name;
    
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
