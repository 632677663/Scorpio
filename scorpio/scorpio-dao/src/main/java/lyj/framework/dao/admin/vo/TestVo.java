package lyj.framework.dao.admin.vo;

import java.io.Serializable;

public class TestVo implements Serializable{
    /** 
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
    */
    private static final long serialVersionUID = 7536246019864279364L;
    private String id;
    private String no;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}
