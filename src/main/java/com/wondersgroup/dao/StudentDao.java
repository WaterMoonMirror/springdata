package com.wondersgroup.dao;

import com.wondersgroup.Student;

import java.util.List;

/**
 * 使用传统方式访问dao
 */
public interface StudentDao {

    /**
     * 添加
     * @param student
     */
    public  void add(Student student);

    /**
     * 查询
     * @return
     */
    public List<Student> query();
}
