package com.lyg.demo3.dao.mapper;

import com.lyg.demo3.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SqlMapper {
    /**
     * 动态sql查询对象
     * @param user
     * @return
     */
    List<User> selectByUser(User user);

    List<User> selectByUser2(User user);

    /**
     * 根据id批量删除用户
     * @param ids
     * @return
     */
    int deleteMoreByArray(@Param("ids") Integer[] ids);

    /**
     * 批量添加用户
     * @param users
     * @return
     */
    int addMoreByArray(@Param("users") List<User> users);

    User selectParam();
}
