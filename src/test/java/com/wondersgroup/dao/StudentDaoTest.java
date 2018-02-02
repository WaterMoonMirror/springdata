package com.wondersgroup.dao;

import com.wondersgroup.Student;
import com.wondersgroup.dao.StudentDao;
import com.wondersgroup.dao.StudentDaoImpl;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {
    @Test
    public void testJdbc() {
        StudentDao studentDao=new StudentDaoImpl();
        Student student=new Student();
        student.setAge(21);
        student.setName("xiaoliu");
        studentDao.add(student);

    }
    @Test
    public  void testquery(){
        StudentDao studentDao=new StudentDaoImpl();
        List<Student> mapList = studentDao.query();
        for (Student student :
                mapList) {
            System.out.println("student:id:"+student.getId()+",name:"+student.getName()+",age"+student.getAge());
        }
    }
}
