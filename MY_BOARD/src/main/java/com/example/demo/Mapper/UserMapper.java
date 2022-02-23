package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.DTO.User;

@Mapper
public interface UserMapper {
	@Select("select * from user where username=#{username}")
	User getUserInfo(@Param("username") String username);
	
	@Insert("insert into user (username,pw,nickname) values(#{user.username},#{user.pw},#{user.nickname})")
	boolean createUser(@Param("user")User user);
	
	@Select("select id from user where username =#{username}")
	Integer isDuplicate(@Param("username") String username);
}