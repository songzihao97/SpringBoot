package com.szh.springbootdata.mapper;

import com.szh.springbootdata.bean.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
