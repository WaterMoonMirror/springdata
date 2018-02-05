package com.wondersgroup.repository;

import com.wondersgroup.dao.StudentDao;
import com.wondersgroup.dao.StudentTemplateDaoImpl;
import com.wondersgroup.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest {
    private ApplicationContext ctx=null;
    private EmployeeRepository dao;
    @Before
    public void setUP(){
        ctx=new ClassPathXmlApplicationContext("bean-jpa.xml");
        // 使用class检索bean
        dao=ctx.getBean(EmployeeRepository.class);
    }
    @After
    public  void tearDowon(){
        ctx=null;
    }

    @Test
    public void findEmployeeByName() {
        Employee employee = dao.findEmployeeByName("zhangsan");
        System.out.println(employee);
    }

    @Test
    public void findByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = dao.findByNameStartingWithAndAgeLessThan("lisi",80);
        for (Employee employee:
                employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void findByNameInOrAgeLessThan() {
        List<String> name=new ArrayList<String>();
        name.add("lisi1");
        name.add("lisi2");
        List<Employee> employees = dao.findByNameInOrAgeLessThan(name,80);
        for (Employee employee:
                employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void queryByIdMax() {

        Employee employee = dao.queryByIdMax();
        System.out.println(employee);

    }

    @Test
    public void queryParam1() {


        List<Employee> employees = dao.queryParam1("lisi2",56);
        for (Employee employee:
                employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void queryParam2() {


        List<Employee> employees = dao.queryParam1("lisi2",56);
        for (Employee employee:
                employees) {
            System.out.println(employee);
        }

    }
}