package com.lyg.mybatisdemo.controller;

import com.lyg.mybatisdemo.dao.mapper.UserMapper;
import com.lyg.mybatisdemo.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @authord almost
 * @date
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户
     * @return
     */
//    @GetMapping()
//    public User check(){
//        return userMapper.check();
//    }

    /**
     * 查找所有用户
     */
    @GetMapping("all")
    public List<User> checkAll(){
        return userMapper.checkAll();
    }

    /**
     * 查询指定用户
     */
    @GetMapping("{username}")
    public User getUserByUsername(@PathVariable String username){
        return userMapper.getUserByUsername(username);
    }
}
