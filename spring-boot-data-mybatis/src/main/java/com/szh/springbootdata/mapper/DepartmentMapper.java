package com.szh.springbootdata.mapper;

import com.szh.springbootdata.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public void insertDept(Department department);

    @Update("update department set (department_name=#{departmentName}) where id=#{id}")
    public void updateDept(Department department);
}
