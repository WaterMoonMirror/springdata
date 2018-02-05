package com.wondersgroup.dao;

import com.wondersgroup.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentTemplateDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public void add(Student student) {

        String sql="insert student(name,age) value(?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});

    }

    public List<Student> query() {
        final List<Student> mapList=new ArrayList<Student>();
        String sql="select * from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                Student  student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                mapList.add(student);
            }
        });
        return mapList;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
