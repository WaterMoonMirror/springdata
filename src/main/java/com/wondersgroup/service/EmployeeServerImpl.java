package com.wondersgroup.service;

import com.wondersgroup.domain.Employee;
import com.wondersgroup.repository.EmployeeCurdRepository;
import com.wondersgroup.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServerImpl implements EmployeeServer {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCurdRepository employeeCurdRepository;
    @Transactional
    public void update(String name, int id) {
        employeeRepository.update(name,id);
    }

    /**
     * 添加一组记录
     * @param employeeList
     */
    public  void save(List<Employee> employeeList){
        employeeCurdRepository.save(employeeList);
    }


}
