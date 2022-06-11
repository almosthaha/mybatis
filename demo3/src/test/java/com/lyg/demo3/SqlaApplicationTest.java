package com.lyg.demo3;

import com.lyg.demo3.dao.mapper.SqlMapper;
import com.lyg.demo3.dao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author almost
 * @date 2022/6/9 14:05
 */
@SpringBootTest
public class SqlaApplicationTest {
    @Autowired
    private SqlMapper sqlMapper;

    @Test
    public void selectByUser(){
        //System.out.println(sqlMapper.selectByUser(new User(null,"张三",null,11,"男","111",null)));
    }

    @Test
    public void selectByUser2(){
        //System.out.println(sqlMapper.selectByUser(new User(null,"张三",null,11,"男","111",null)));
    }

    @Test
    public void deleteMoreByArray(){
        //System.out.println(sqlMapper.deleteMoreByArray(new Integer[]{5,6}));
    }

    @Test
    public void addMoreByArray(){
//        User user1=new User(null,"晴天",null,36,"男","555");
//        User user2=new User(null,"白云",null,35,"女","666");
//        User user3=new User(null,"风",null,33,"女","777");
//        List<User> userList= Arrays.asList(user1,user2,user3);
//        System.out.println(sqlMapper.addMoreByArray(userList));
    }

    @Test
    public void selectParam(){
        System.out.println(sqlMapper.selectParam());
    }
}

