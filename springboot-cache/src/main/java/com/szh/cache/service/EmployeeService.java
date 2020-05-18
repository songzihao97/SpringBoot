package com.szh.cache.service;

import com.szh.cache.dao.EmployeeMapper;
import com.szh.cache.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * @Cacheable :将方法结果进行缓存
     * @param id
     * @return
     *  key:指定key，不指定则默认为第一个参数
     *  cacheManager:指定缓存管理器
     *  condition：指定符合条件的情况下才缓存
     *  unless:指定不缓存条件 #result代表取返回值
     *  sync:是否使用异步缓存
     */
    @Cacheable(cacheNames = "emp"/*,key = "#id",condition ="#id>0",unless = "#result==null"*/)
    public Employee findEmp(Integer id){
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    /**
     * @CachePut 执行方法并更新缓存
     * @param employee
     * @return
     */
    @CachePut(cacheNames = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateByPrimaryKeySelective(employee);
        Employee employee1 = employeeMapper.selectByPrimaryKey(employee.getId());
        return employee1;
    }

    /**
     * @cache 清除缓存
     * @param id
     */
    @CacheEvict(value = "emp",key ="#id")
    public void delEmp(Integer id){
        System.out.println("del"+id);
//        employeeMapper.deleteByPrimaryKey(id);
    }
}
