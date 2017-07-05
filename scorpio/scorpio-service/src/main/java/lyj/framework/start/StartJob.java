package lyj.framework.start;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @ClassName: StartJob
 * @Description: 服务启动入口函数
 * @author lyj
 * @date 2017年5月23日 下午2:28:00
 */
public class StartJob {
    
    private static Logger logger = Logger.getLogger(StartJob.class);
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        
        logger.info("job start ....");
        
        while(true){
            
        }
        
    }
}
