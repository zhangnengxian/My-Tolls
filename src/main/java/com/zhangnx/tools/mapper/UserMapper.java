package com.zhangnx.tools.mapper;


import com.zhangnx.tools.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;



public interface UserMapper {

	@Select("select * from user")
	List<User> getAll();
	
	@Select("select * from user where id=#{id}")
	User getUserById(@Param("id") int id);
}
