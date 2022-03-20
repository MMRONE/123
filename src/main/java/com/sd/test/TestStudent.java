package com.sd.test;


import com.sd.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

import java.io.IOException;
import java.io.InputStream;

public class TestStudent {
    public static void main(String[] args) {
        String resource="mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sessionFactory.openSession();
        Student student = sqlSession.selectOne("test1.getById", "1");
        System.out.println(student);
        sqlSession.close();

    }
}
