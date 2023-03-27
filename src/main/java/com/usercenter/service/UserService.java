package com.usercenter.service;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usercenter.model.domain.User;

/**
 * @author zcy
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-02-14 20:18:22
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验码
     * @param planetCode 星球编号
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     * 
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser 原user
     * @return 脱敏后的user
     */
    User getSafetyUser(User originUser);

    /**
     * 移除登录态
     * 
     * @param request 请求
     */
    int userLogout(HttpServletRequest request);
}
