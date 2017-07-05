package lyj.framework.util;

import java.util.UUID;

/**
 * 
* @ClassName: SerialNoUtil 
* @Description: 流水号生成工具类
* @author lyj 
* @date 2017年7月5日 下午3:39:22
 */
public class SerialNoUtil {
    /**
     * 生成UUID
     * @return uuid
     */
    public static String getSerialNo(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
}
