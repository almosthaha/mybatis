package com.lyg.demo3.dao.mapper;

import com.lyg.demo3.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 根据id查询员工所在部门的信息
     * @param id
     * @return
     */
    @ResultMap("userResultType2")
    User getUserAndDepartment(@Param("id") Integer id);



    /**
     * 多条件动态查询
     * @param user
     * @return
     */
    List<User> getUserCondition(User user);
}
