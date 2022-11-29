package com.example.myspring.mapper;

import com.example.myspring.entity.UserBean;
import com.example.myspring.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user LIMIT #{from} , 5")
    List<User> toAll(@Param("from")int from);
    //查询，可以实现登录功能
    @Select("SELECT * FROM User WHERE username = #{name} AND password = #{password} LIMIT 1")
    UserBean getInfo(@Param("name") String name, @Param("password") String password);

    @Select("SELECT * FROM User WHERE email = #{email} LIMIT 1")
    UserBean getInfoByEmail(@Param("email") String email);

    //多个参数要加@Param修饰
    //增加，可以实现注册功能
    @Insert("insert into User(username,password,email)values(#{name},#{password},#{email})")
    void saveInfo(@Param("name") String name, @Param("password") String password, @Param("email") String email);

}