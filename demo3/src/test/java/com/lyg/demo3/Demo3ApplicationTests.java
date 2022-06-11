package com.lyg.demo3;

import com.lyg.demo3.dao.mapper.DepartMapper;
import com.lyg.demo3.dao.mapper.UserMapper;
import com.lyg.demo3.dao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo3ApplicationTests {

    @Autowired
    private DepartMapper departMapper;

    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() {
    }

    @Test
    public void getDepartmentByAll(){
        System.out.println(departMapper.getDepartmentByAll(3));
    }

    @Test
    public void getUserAndDepartment(){
        System.out.println(userMapper.getUserAndDepartment(3));
    }

    @Test
    public void getDepartmentByStepOne(){
        System.out.println(departMapper.getDepartmentByStepOne(1));
    }

    @Test
    public void getUserCondition(){
        //System.out.println(userMapper.getUserCondition(new User(null,"张三",null,11,"男","111",null)));
    }
}
