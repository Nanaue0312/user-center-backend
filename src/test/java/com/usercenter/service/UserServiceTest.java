package com.usercenter.service;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.usercenter.model.domain.User;

/**
 * 用户服务测试
 * 
 * @author nanaue
 */
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void testAdd() {
        User user = new User();
        user.setUsername("dogYupi");
        user.setUserAccount("123");
        user.setAvatarUrl(
            "https://thirdwx.qlogo.cn/mmopen/vi_32/MicPUicpUDlXc2WiafR5hh6mABgy4KBHfkuPtO3Upy5hGklv0rBTEJwO2Ha9GeORFohzthD9PBOtv0zAL3KkzjAsA/132");
        user.setGender(0);
        user.setUserPassword("123456");
        user.setPhone("123");
        user.setEmail("123");
        boolean res = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertEquals(res, true);
    }

    @Test
    void userRegister() {
        String userAccount = "yupi";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1";
        long l = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, l);

        userAccount = "yu";
        l = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, l);

        userAccount = "yupi";
        userPassword = "123456";
        l = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, l);
        userAccount = "yu pi";
        l = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, l);
        checkPassword = "123456789";
        userPassword = "12345678";
        l = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, l);
        userAccount = "dogYupi";
        checkPassword = "12345678";
        l = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, l);
        userAccount = "yupi";
        l = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertTrue(l > 0);
    }
}