package com.lyg.mybatisdemo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyg.mybatisdemo.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * mybatis 获取参数值的两种方式:${}和 #{}
 * ${}本质是字符串拼接 () 会有sql注入的风险
 * #{}本质是占位符赋值
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 添加用户
     */
    int insert();

    /**
     *修改用户信息
     */
    int update();

    /**
     * 删除用户
     */
    int delete();

    /**
     * 查询的结果可能是一条数据，也可能是多条数据
     * 一条数据：实体类对象
     * 多条数据：list集合
     * resultType 跟 resultMap的区别
     * resultType适用于字段名跟属性名相同的情况下
     * resultMap适用于字段名与属性名不同，或者实体
     * 对象(表的关系为一对一或者一对多的情况)
     *
     * @return
     */
    User check();

    /**
     * 查询所有用户信息
     */
    List<User> checkAll();

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * 要查询多个条件时
     * 要在接口中加入@Param("") 这是mybatis底层的原理，把数据放在map中
     */
    User checkLogin(@Param("username") String username,@Param("password")
            String password);

    /**
     * 验证登录(参数为map)
     */
    User checkLoginMap(Map<String,Object> map);


    /**
     * 添加用户信息
     */
    int add(User user);

    List<User> getUserByLike(String password);
}
