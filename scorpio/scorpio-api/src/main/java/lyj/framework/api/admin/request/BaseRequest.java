package lyj.framework.api.admin.request;

import java.io.Serializable;

/**
 * 
* @ClassName: BaseRequest 
* @Description: 接口请求基类
* @author lyj 
* @date 2017年7月5日 下午2:15:07
 */
public class BaseRequest implements Serializable{

    /** 
    * @Fields serialVersionUID : 
    */
    private static final long serialVersionUID = 950738210770322240L;

    //流水号
    private String serialNo;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
