package com.wondersgroup.dao;

import com.wondersgroup.Student;
import com.wondersgroup.utill.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements  StudentDao {
    public void add(Student student) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="insert student(name,age) value(?,?)";
        try {
            connection=JDBCUtil.getConnection();
            statement=connection.prepareStatement(sql);
             statement.setString(1,student.getName());
             statement.setInt(2,student.getAge());
             statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,statement,resultSet);
        }

    }

    public List<Student> query() {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from student";
        try {
            connection=JDBCUtil.getConnection();
             statement = connection.prepareStatement(sql);
             resultSet=statement.executeQuery();
            List<Student> mapList=new ArrayList<Student>();
            Student student=null;
             while (resultSet.next()){
                 student=new Student();
                 student.setId(resultSet.getInt("id"));
                 student.setName(resultSet.getString("name"));
                 student.setAge(resultSet.getInt("age"));
                 mapList.add(student);
             }
             return mapList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,statement,resultSet);
        }
        return null;
    }
}
