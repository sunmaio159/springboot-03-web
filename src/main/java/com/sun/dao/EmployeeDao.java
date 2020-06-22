package com.sun.dao;

import com.sun.pojo.Department;
import com.sun.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employeeMap.put(101,new Employee(1001,"zhan","384093568@qq.com",1,new Department(101,"教学部"),new Date()));
        employeeMap.put(102,new Employee(1002,"li","384093568@qq.com",1,new Department(10102,"市场部"),new Date()));
        employeeMap.put(103,new Employee(1003,"zhao","384093568@qq.com",1,new Department(103,"教研部"),new Date()));
        employeeMap.put(104,new Employee(1004,"wang","384093568@qq.com",1,new Department(104,"运营部"),new Date()));
        employeeMap.put(105,new Employee(1005,"tian","384093568@qq.com",1,new Department(105,"后勤部"),new Date()));
    }

    public Collection<Employee> getDepartment(){
        return employeeMap.values();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }
}

