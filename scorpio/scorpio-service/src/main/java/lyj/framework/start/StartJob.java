package lyj.framework.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lyj.framework.api.admin.response.TestResponse;
import lyj.framework.api.admin.service.TestService;
import lyj.framework.dao.admin.vo.TestVo;

/**
 * 
 * @ClassName: StartJob
 * @Description: 服务启动入口函数
 * @author lyj
 * @date 2017年5月23日 下午2:28:00
 */
public class StartJob {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        
        TestService service = (TestService) context.getBean("testService");
        
        TestResponse vo = service.findTest("7");
        
        System.out.println(vo.getNo());
        
        System.out.println("end...");
        
        
        while(true){
            
        }
        
    }
}
