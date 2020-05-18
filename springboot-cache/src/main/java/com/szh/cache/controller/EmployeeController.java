package com.szh.cache.controller;

import com.szh.cache.dao.EmployeeMapper;
import com.szh.cache.domain.Employee;
import com.szh.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee findOne(@PathVariable("id") Integer id){
        Employee emp = employeeService.findEmp(id);
        return emp;
    }

    @GetMapping("/emp")
    @ResponseBody
    public Employee editEmp(Employee employee){
        employeeService.updateEmp(employee);
        return employee;
    }

    @GetMapping("/delemp/{id}")
    @ResponseBody
    public String delEmp(@PathVariable("id") Integer id){
        employeeService.delEmp(id);
        return id.toString();
    }

}
