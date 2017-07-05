package lyj.framework.api.admin.response;

import java.io.Serializable;
/**
 * 
* @ClassName: BaseReponse 
* @Description: 接口返回基类
* @author lyj 
* @date 2017年7月5日 下午2:12:40
 */
public class BaseReponse implements Serializable{

    /** 
    * @Fields serialVersionUID : 
    */
    private static final long serialVersionUID = 8232582164097144141L;
    
    //流水号
    private String serialNo;
    //返回码
    private String returnCode;
    //返回信息
    private String returnMessage;
    public String getSerialNo() {
        return serialNo;
    }
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
    public String getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    public String getReturnMessage() {
        return returnMessage;
    }
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
