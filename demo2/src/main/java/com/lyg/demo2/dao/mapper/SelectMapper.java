package com.lyg.demo2.dao.mapper;


import com.lyg.demo2.dao.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * mybatis的各种数据查询
 * 1.若查出的数据只有一条(可以通过实体类对象接收,可以通过list集合接收)
 * 2.若查出的数据有多条 (可以通过list集合接收，一定不能通过实体类对象接收
 * 此时会抛出异常toomanyResultsException)
 *
 * mybatis中设置了默认的类型别名
 * java.lang.integer-->int,integer
 * map-->map
 * string-->string
 */
@Mapper
public interface SelectMapper {


    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询一个集合
     * @return
     */
    List<User> getUserAll();

    /**
     * 查询用户信息的总记录数
     */
     Integer getcount();

    /**
     * map查询的结果为无序的 如果数据库查询的结果没有任何一个实体类能与他对应(常用做多表查询)
     * 那么就转换为map，以字段为键，以字段的值为值(键值形式)
     * @param id
     * @return
     */

    @MapKey("id")
    Map<String,Object> getUserByIdMap(Integer id);

    /*@MapKey("id")
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);*/


    /**
     * 查询所有用户信息的map集合
     */

    @MapKey("id")
    //@MapKey把设置当前map集合的键，他会把我们当前查询出来的数据的某一个字段作为键
    //当前查询出来数据转换成的map集合作为值
    //把id作为键，不会重复，为唯一值
   // List<Map<String,Object>> getAllUserToMap();
    Map<String,Object> getAllUserToMap();



}
