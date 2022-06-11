package com.lyg.demo2;

import com.lyg.demo2.dao.mapper.SqlMapper;
import com.lyg.demo2.dao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @authord almost
 * @date 2022/6/6 23:01
 */
@SpringBootTest
public class SqlMapperTest {

    @Autowired
    private SqlMapper sqlMapper;

    @Test
    public void getUserByLike(){
        System.out.println(sqlMapper.getUserByLike("张"));
    }

    @Test
    public void deleteMore(){
        System.out.println(sqlMapper.deleteMore("7,8"));
    }

    @Test
    public void getUserByTableName(){
        System.out.println(sqlMapper.getUserByTableName("user"));
    }

    @Test
    public void insertUsere(){
        User user=new User(null,"赵六","131",18,"男","132");
        sqlMapper.insertUser(user);
        System.out.println(user);
    }
}
