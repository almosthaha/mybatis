package com.lyg.mybatisdemo;

import com.lyg.mybatisdemo.dao.mapper.UserMapper;
import com.lyg.mybatisdemo.dao.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@MapperScan("com.lyg.mybatisdemo.dao.mapper")
class MybatisDemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    private UserMapper userMapper;
    @Test
    public void add(){
        System.out.println(userMapper.insert());
    }

    @Test
    public void update(){
        System.out.println(userMapper.update());
    }

    @Test
    public void delete(){
        System.out.println(userMapper.delete());
    }

    @Test
    public void check(){
        System.out.println(userMapper.check());
    }

    @Test
    public void checkAll(){
        System.out.println(userMapper.checkAll());
    }

//    @Test
//    public void getUserByUsername(){
//        //System.out.println(userMapper.getUserByUsername(1));
//    }




    @Test
    public void  checkLoginMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","张三");
        map.put("password","123");
        User user = userMapper.checkLoginMap(map);
        System.out.println(user);
    }
    //增加测试
    @Test
    public void add2(){
        System.out.println( userMapper.add(new User(null, "晴天", "130", 17, "男", "131")));
    }

    @Test
    public void getUserByUsername(){
        System.out.println(userMapper.getUserByUsername("张三"));
    }

    @Test
    public void getUserByLike(){
        System.out.println(userMapper.getUserByLike("1"));
    }
}
