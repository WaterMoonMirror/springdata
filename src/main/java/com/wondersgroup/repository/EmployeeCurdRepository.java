package com.wondersgroup.repository;

import com.wondersgroup.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * 继承CrudRepository，实现增删改查操作
 */
public interface EmployeeCurdRepository extends CrudRepository<Employee,Integer> {

}
