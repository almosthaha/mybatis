package com.lyg.demo2.dao.mapper;

import com.lyg.demo2.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SqlMapper {

    /**
     * 模糊查询
     * @param username
     * @return
     */
    User getUserByLike(@Param("username") String username);


    /**
     * 删除多个
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);


    /**
     * 查询指定表中的数据
     * @param tableName
     * @return
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    void insertUser(User user);
}
