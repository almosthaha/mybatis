package com.lyg.demo3.dao.mapper;

import com.lyg.demo3.dao.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 1.if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到sql中
 * 2.where:
 * 当where标签中有内容时，会自动生成where关键字，并且将多余的and或or去掉
 * 当where标签中没有内容的，此时的where没有任何效果
 */
@Mapper
public interface DepartMapper {

    /**
     * 根据部门id查询所有部门的信息
     * @return
     */
    List<Department> getDepartmentByAll(@Param("departmentid") Integer departmentid);

    /**
     * 据部门id查询员工所对应的信息
     * @param departmentid
     * @return
     */
    Department getDepartmentByStepOne(@Param("departmentid") Integer departmentid);

}
