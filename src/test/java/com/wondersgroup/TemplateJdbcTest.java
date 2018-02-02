package com.wondersgroup;

import com.wondersgroup.dao.StudentDao;
import javafx.application.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class TemplateJdbcTest {

    private ApplicationContext ctx=null;
    private StudentDao dao;
    @Before
    public void setUP(){
        ctx=new ClassPathXmlApplicationContext("bean.xml");
    }
    @After
    public  void tearDowon(){
        ctx=null;
    }

    @Test
    public void TestDataSource(){
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(dataSource );
    }
}
