package com.unity.authentication.manager.dao;

import com.unity.authentication.manager.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by xuhelaw on 2020/10/18.
 */
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name= #{name}")
    User queryUserByName(@Param("name") String name);
}
