package com.mybatis.test;

import com.mybatis.bean.Employee;
import com.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Iterator;

public class  MBGTest {

    @Test
    public void test01(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        InputStream resourceAsStream = MBGTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = builder.build(resourceAsStream);

        SqlSession openSession = factory.openSession();

        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

        Iterator<Employee> iterator = mapper.selectAll().iterator();

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee);
        }


    }

}
