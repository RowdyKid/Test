package com.cms.contractmanagementsystem.service;

import com.cms.contractmanagementsystem.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);

    /**
     * 通过id 查询用户名
     * @param
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public String queryusernamebyID(int id);

}
