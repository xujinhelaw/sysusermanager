package com.unity.authentication.manager.dao;

import com.unity.authentication.manager.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by xuhelaw on 2020/10/18.
 */
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name= #{name}")
    User queryUserByName(@Param("name") String name);

    @Update("Update user SET id = #{user.id},name = #{user.name},age=#{user.age},email=#{user.email} WHERE name = #{user.name}")
    void UpdateUserByName(@Param("user")User user);
}
