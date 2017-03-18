package com.bigsnow;
/**
 * Struts��Action�࣬��ӦJSPҳ��
 * 
 * @author WLSK801
 * @version 2017.03.17
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mybatis.dao.SegmentDao;
import com.mybatis.entity.Segment;
import com.opensymphony.xwork2.ActionSupport;
public class SegmentInput extends ActionSupport {
	/**
	 * AJAX���ص�Stringֵ
	 */
    private String dnaSeg;

	public String getDnaSeg() {
		
		return dnaSeg;
	}

	public void setDnaSeg(String dnaSeg) {
		this.dnaSeg = dnaSeg;
	}
	/**
     * ÿ�ε���Action�඼���Զ������ⷽ��
     * 
     * @return SUCCESS����ERROR
     */
	@Override  
    public String execute() throws Exception{
		// ����Bean����
		ApplicationContext ctx=null;
        ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        // ��Bean����Dao��POJO
        SegmentDao segmentDao = (SegmentDao) ctx.getBean("segmentDao");
        // ʵ����Segment�Ķ���
        Segment s01 = new Segment();
		s01.setSeg(this.getDnaSeg());
		// ͨ��Dao����insert����
        segmentDao.insertSeg(s01);
        System.out.println(dnaSeg);
//		DataConnection conn = new DataConnection();
//		conn.insertRow(s01);
//		System.out.println("Hello111");
//		System.out.println(dnaSeg);
        return SUCCESS;  
    }  
}
