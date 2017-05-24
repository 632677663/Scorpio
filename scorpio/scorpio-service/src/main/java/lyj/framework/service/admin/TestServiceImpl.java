package lyj.framework.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyj.framework.api.admin.response.TestResponse;
import lyj.framework.api.admin.service.TestService;
import lyj.framework.dao.admin.TestDao;
import lyj.framework.dao.admin.vo.TestVo;
@Service("testService")
public class TestServiceImpl implements TestService {
    
    @Autowired
    private TestDao testDao;
    
    @Override
    public TestResponse findTest(String id) {
        
        TestResponse response = new TestResponse();
        
        TestVo findTest = testDao.findTest(id);
        
        response.setId(findTest.getId());
        response.setNo(findTest.getNo());
        
        System.out.println("doing...");
        
        return response;
        
    }

}
