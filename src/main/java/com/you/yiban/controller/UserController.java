package com.you.yiban.controller;

import com.you.yiban.entity.User;
import com.you.yiban.service.UserService;
import com.you.yiban.util.ResultUtil;
import com.you.yiban.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author w.z
 * @date 2019/8/12 10:06
 */

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo checkLogin(String username, String password) {
        User user = userService.checkLogin(username, password);
        if (user != null) {
            user.setPassword(null);
            return ResultUtil.success(user);
        } else {
            return ResultUtil.error("用户名或密码错误");
        }
    }

    /**
     * 用户角色
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/userInformation", method = RequestMethod.GET)
    @ResponseBody
    public ResultVo getUserInformation(String username) {
        String userType = userService.getUserInformation(username);
        if (userType != null) {
            return ResultUtil.success(userType);
        } else {
            return ResultUtil.error("没有查到type数据");
        }
    }
}