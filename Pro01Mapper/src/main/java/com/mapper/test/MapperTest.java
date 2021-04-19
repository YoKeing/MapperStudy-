package com.mapper.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MapperTest {


    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");


    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);


    }

}
