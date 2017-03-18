package com.mybatis.dao;
/**
 * ���ݿ�����࣬����ʹ����Spring���ѷ���
 * 
 * @author WLSK801
 * @version 2017.03.17
 */
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.entity.Segment;

public class DataConnection {
	
	public void insertRow(Segment seg) {
		// mybatis�������ļ�
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
        	inputStream = Resources.getResourceAsStream(resource);
            // 1. create factory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
            // 2. get SqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 3. manipulate database buy sqlsession
            // ��һ��������ӳ���ļ��е�statement��Id,����namespace + "." + statement��id;
            // �ڶ�������:ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���;
            // sqlSession.selectOne�������ӳ���ļ���ƥ���resultType���͵Ķ���;
            sqlSession.insert("test.insertSegment", seg);
            //ִ���ύ����
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
