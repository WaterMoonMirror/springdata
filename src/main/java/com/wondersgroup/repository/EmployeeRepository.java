package com.wondersgroup.repository;

import com.wondersgroup.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository  {

    /**
     * 按照员工姓名查询
     * @param name
     * @return
     */
    public  Employee findEmployeeByName (String name);

    /**
     * Repository 中查询方法的规则使用
     *
     * where name like ?% and age <?
     */
    public List<Employee> findByNameStartingWithAndAgeLessThan (String name,Integer age);


    /**
     * where name in(?,?....) and age<?
     *
     */

    public  List<Employee> findByNameInOrAgeLessThan(List<String> names,Integer age);


    /**
     * @Query 注解方法的使用
     *
     * 查询employee中id最大的一个
     */

    @Query("select  o from  Employee  o where  o.id =(select  max (id) from Employee )")
    public  Employee queryByIdMax();

    /**
     * 占位符传参
     *
     * @param name
     * @param age
     * @return
     */
    @Query("select  o from  Employee o where  o.name = ?1 and" +
            " o.age = ?2")
    public List<Employee> queryParam1(String name ,int age);

    /**
     * 标识符传参
     *
     * @param name
     * @param age
     * @return
     */
    @Query("select  o from  Employee o where  o.name = :name and o.age= :age")
    public List<Employee> queryParam2(@Param("name") String name ,@Param("age") int age);

    /**
     * 更新操作
     * 1. 需要添加@Modifying注解
     * 2. 更新必须在server层操作
     * 3. server层更新方法需要添加@Transctional事务注解
     * @param name
     * @param id
     */
    @Query("update Employee  set name=?1 where  id=?2")
    public  void update(String name ,int id);
}
