package com.lyg.demo3.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author almost
 * @date 2022/6/8 17:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer departmentid;
    private String departmentname;

    private List<User> users;
}
