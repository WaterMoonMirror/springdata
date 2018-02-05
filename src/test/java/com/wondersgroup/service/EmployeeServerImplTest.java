package com.wondersgroup.service;

import com.wondersgroup.domain.Employee;
import com.wondersgroup.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeServerImplTest {

    private ApplicationContext ctx=null;
    private EmployeeServer employeeServer;
    @Before
    public void setUP(){
        ctx=new ClassPathXmlApplicationContext("bean-jpa.xml");
        // 使用class检索bean
        employeeServer=ctx.getBean(EmployeeServerImpl.class);
    }
    @After
    public  void tearDowon(){
        ctx=null;
    }

    @Test
    public  void upate(){
        employeeServer.update("王五",3);
    }
    @Test
    public  void save(){
        List<Employee> employeeList=new ArrayList<Employee>();

        for (int i = 0; i < 100; i++) {
            employeeList.add(new Employee("test"+i,100-i));

        }
        employeeServer.save(employeeList);
    }

}