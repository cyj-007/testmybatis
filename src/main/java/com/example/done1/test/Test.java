package com.example.done1.test;

import cn.hutool.core.util.ReflectUtil;
import com.example.done1.dao.UserEntity;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
//        Method[] methods = ReflectUtil.getMethods(UserEntity.class);

//        Method getNickName = ReflectUtil.getMethod(UserEntity.class, "getNickName");

//        ReflectUtil.newInstance(UserEntity.class);

//        Object getNickName = ReflectUtil.invoke(ReflectUtil.newInstance(UserEntity.class), "getNickName");
        Object getNickName = ReflectUtil.invoke(new UserEntity(), "getNickName");
        System.out.println(getNickName);

    }

}
