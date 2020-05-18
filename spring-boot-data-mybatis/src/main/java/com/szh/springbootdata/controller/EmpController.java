package com.szh.springbootdata.controller;

import com.szh.springbootdata.bean.Employee;
import com.szh.springbootdata.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee empById = employeeMapper.getEmpById(id);
        return empById;
    }
}
