package com.lyg.demo2;

import com.lyg.demo2.dao.mapper.SelectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo2ApplicationTests {
    @Autowired
    private SelectMapper selectMapper;


    @Test
    void contextLoads() {
    }

    @Test
    public void getUserById(){
        System.out.println(selectMapper.getUserById(1));
    }

    @Test
    public void getUserall(){
        System.out.println(selectMapper.getUserAll());
    }

    @Test
    public void getcount(){
        System.out.println(selectMapper.getcount());
    }

    @Test
    public void getUserByIdMap(){
        System.out.println(selectMapper.getUserByIdMap(1));
    }

    @Test
    public void getUserByIdToMap(){
        System.out.println(selectMapper.getUserByIdMap(1));
    }

    @Test
    public void getAllUserToMap(){
        System.out.println(selectMapper.getAllUserToMap());
    }


}
