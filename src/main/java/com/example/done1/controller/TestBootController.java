package com.example.done1.controller;

import com.example.done1.dao.UserEntity;
import com.example.done1.mapper.UserMapper;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Admin
 */
@RestController
@RequestMapping("/testboot")
public class TestBootController {

    @Resource
    UserMapper userMapper;

    /**
     * 查询所有
     * */
    @GetMapping("getuser")
    public List<UserEntity> getUser() {
        return userMapper.queryList();
    }

    /**
     * 根据id查询
     * */
    @GetMapping("id")
    public UserEntity getId(@RequestParam int id) {
        return userMapper.getId(id);
    }

    /**
     * 修改数据
     * */
    @GetMapping("update")
    public void update(){
        UserEntity userEntity = UserEntity.builder().id(4).userCode("2222").userName("22222").build();
        userMapper.update(userEntity);
    }

    /**
     * 删除数据
     * */
    @GetMapping("delete")
    public void delete(@RequestParam int id){
        userMapper.delete(id);
    }

    /**
     *  新增
     * */
    @GetMapping("insert")
    public void insert(){
        UserEntity userEntity=UserEntity.builder().userCode("2222").userName("2222").createDate(new Date()).build();
        userMapper.save(userEntity);
    }
}
