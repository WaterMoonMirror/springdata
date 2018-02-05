package com.wondersgroup.domain;

import javax.persistence.*;
@Entity
@Table(name = "employee_curd")
public class Employee {


    private Integer id;

    private String name;
    private int age;




    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // 设置主键（自增）
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    @Column(length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
