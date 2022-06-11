package com.lyg.demo3.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author almost
 * @date 2022/6/8 17:01
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;

    /**
     * 多对一关系
     */


    private Department department;


//     <resultMap id="userResultType" type="com.lyg.demo3.dao.pojo.User">
//        <id property="id" column="id"></id>
//        <result property="username" column="username"></result>
//        <result property="password" column="password"></result>
//        <result property="age" column="age"></result>
//        <result property="sex" column="sex"></result>
//        <result property="email" column="email"></result>
//
//<!--        这里多对一的对象 字段名直接写表中的字段名，不用跟属性名一样，多细心-->
//        <result property="department.departmentid" column="departmentid"></result>
//        <result property="department.departmentname" column="departmentname"></result>
//    </resultMap>
}
