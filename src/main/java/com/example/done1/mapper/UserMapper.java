package com.example.done1.mapper;

import com.example.done1.dao.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Admin
 */
@Mapper
public interface UserMapper {
//    @Select("select * from user")
//    @Results({
//            @Result(property = "userId", column = "user_id"),
//            @Result(property = "nickName", column = "nick_name"),
//            @Result(property = "userCode", column = "user_code"),
//            @Result(property = "userName", column = "user_name"),
//            @Result(property = "userPwd", column = "user_pwd"),
//            @Result(property = "createDate", column = "create_date"),
//            @Result(property = "updateDate", column = "update_date") })
//    List<UserEntity> queryList();

    /**
     * 查询全部
     * */
    @Select("select * from user")
    List<UserEntity> queryList();

    /**
     * 新增数据
     * */
//    @Insert(" insert into  user(id,user_code,user_name,nick_name,user_pwd,create_date,update_date ) " +
    @Insert(" insert into  user " +
            "values (#{id},#{userCode},#{userName},#{nickName},#{userPwd},#{createDate},#{updateDate}) ")
    int save(UserEntity user);

    /**
     * 删除数据
     * */
    @Delete(" delete from user where id= #{id} ")
    int delete(int id);

    /**
     * 根据id查找
     * */
    @Select("select * from user where id= #{id} ")
    UserEntity getId(int id);

    /**
     * 更新数据
     * */
    @Update("update user set user_code=#{userCode},user_name=#{userName} where id=#{id} ")
    int update(UserEntity user);


}
