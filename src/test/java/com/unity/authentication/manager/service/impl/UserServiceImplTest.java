package com.unity.authentication.manager.service.impl;

import com.unity.authentication.manager.dao.UserMapper;
import com.unity.authentication.manager.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    //根据用户名查询用户对象，查询成功
    @Test
    void testQueryUserByName_querySuccess() {
        User userExpected = new User();
        userExpected.setName("Eli");
        userExpected.setId(12345);
        userExpected.setAge(18);
        userExpected.setEmail("Eli@163.com");
        when(userMapper.queryUserByName(anyString())).thenReturn(userExpected);

        User userActual = userService.queryUserByName("Eli");

        verify(userMapper, times(1)).queryUserByName("Eli");
        assertEquals(userActual, userExpected);
    }

    //测试更新用户对象，更新成功
    @Test
    void testUpdateUserByName_updateSuccess() {
        User userExpected = new User();
        userExpected.setName("Alice");
        userExpected.setId(54321);
        userExpected.setAge(18);
        userExpected.setEmail("Alice@163.com");
        when(userMapper.queryUserByName("Alice")).thenReturn(userExpected);
        when(userMapper.updateUserByName(any())).thenReturn(true);

        boolean result = userService.updateUserByName(userExpected);

        verify(userMapper, times(1)).queryUserByName("Alice");
        verify(userMapper, atLeast(1)).updateUserByName(userExpected);
        assertTrue(result);
    }

    //测试更新用户对象，执行用户不存在逻辑
    @Test
    void testUpdateUserByName_userNotExist() {
        User user = new User();
        user.setName("Bob");
        when(userMapper.queryUserByName("Bob")).thenReturn(null);

        boolean result = userService.updateUserByName(user);

        verify(userMapper, times(0)).updateUserByName(user);
        assertFalse(result);
    }

    //测试用户Id查询用户对象列表，mock抛出异常
    @Test
    void testQueryUsersByUserIds_throwError() {
        doThrow(new RuntimeException()).when(userMapper).queryUserByUserIds("123,345");

        assertThrows(RuntimeException.class, () -> userService.queryUsersByUserIds("123,345"));
    }
}