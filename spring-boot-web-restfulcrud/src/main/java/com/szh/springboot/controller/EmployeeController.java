package com.szh.springboot.controller;

import com.szh.springboot.dao.DepartmentDao;
import com.szh.springboot.dao.EmployeeDao;
import com.szh.springboot.entities.Department;
import com.szh.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        //查出所有员工
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //跳转员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //跳转到员工添加页面
        return "emp/add";
    }

    //添加员工方法
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //保存员工数据
        employeeDao.save(employee);
        //返回员工页面
        return "redirect:/emps";
    }

    //修改员工页面跳转.查出信息，页面跳转
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        //员工信息回显
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //部门列表回显
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        //修改员工
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        //删除员工
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
