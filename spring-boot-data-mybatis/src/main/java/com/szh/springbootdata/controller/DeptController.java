package com.szh.springbootdata.controller;

import com.szh.springbootdata.bean.Department;
import com.szh.springbootdata.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    @ResponseBody
    public Department getDept(@PathVariable("id") Integer id){
        Department deptById = departmentMapper.getDeptById(id);
        return  deptById;
    }

    @GetMapping("/dept")
    @ResponseBody
    public Department insertDept(Department department){
       departmentMapper.insertDept(department);
       return department;
    }


}
