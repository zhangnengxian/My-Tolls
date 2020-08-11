package com.zhangnx.tools.mapper;

import java.util.List;

import com.zhangnx.tools.beans.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select * from user")
	List<User> getAll();
	
	@Select("select * from user where id=#{id}")
	User getUserById(@Param("id") int id);
}
