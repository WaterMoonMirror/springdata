package com.wondersgroup.service;

import com.wondersgroup.domain.Employee;

import java.util.List;

public interface EmployeeServer {
    /**
     * 更新操作
     * @param name
     * @param id
     */
    public  void  update(String name,int id);

    /**
     * 保存一组记录
     * @param employeeList
     */
    public  void save(List<Employee> employeeList);
}
