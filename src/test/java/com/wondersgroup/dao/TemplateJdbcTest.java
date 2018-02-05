package com.wondersgroup.dao;

import com.wondersgroup.domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class TemplateJdbcTest {

    private ApplicationContext ctx=null;
    private StudentDao dao;
    @Before
    public void setUP(){
        ctx=new ClassPathXmlApplicationContext("bean.xml");
        // 使用class检索bean
        dao=ctx.getBean(StudentTemplateDaoImpl.class);
    }
    @After
    public  void tearDowon(){
        ctx=null;
    }

    /**
     * 测试DataSource
     */
    @Test
    public void TestDataSource(){
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(dataSource);
    }

    /**
     *测试template
     */
    @Test
    public void Testtemplate(){
        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        Assert.assertNotNull(jdbcTemplate);
    }


    /**
     *测试templateQuery
     */
    @Test
    public void TesttemplateQuery(){
        List<Student> query = dao.query();
        for (Student stu :
                query) {
            System.out.println(stu);
        }

    }

    /**
     *测试templateAdd
     */
    @Test
    public void TesttemplateAdd(){

        dao.add(new Student("李四",23));

    }
}
