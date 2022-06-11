package com.lyg.demo2.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @authord almost
 * @date
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;
}
