package lyj.framework.dao.admin;

import lyj.framework.dao.admin.vo.TestVo;

public interface TestDao {
    /**
     * 根据主键查询数据
     * @param id
     * @return
     */
    public TestVo findTest(String id);
    
}
