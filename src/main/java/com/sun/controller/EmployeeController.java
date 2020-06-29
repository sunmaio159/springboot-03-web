package com.sun.controller;

import com.sun.dao.EmployeeDao;
import com.sun.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class EmployeeController {
    @Autowired
    public EmployeeDao employeeDao;

    @RequestMapping("/emps")
    public String list(Model model, HttpSession session){
        System.out.println(session.getAttribute("loginUser"));
        Collection<Employee> employee = employeeDao.getEmployee();
        model.addAttribute("emps",employee);
        return "emp/list";
    }
}
