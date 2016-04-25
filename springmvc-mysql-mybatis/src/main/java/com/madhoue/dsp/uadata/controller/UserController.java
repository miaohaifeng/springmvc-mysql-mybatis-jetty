package com.madhoue.dsp.uadata.controller;

import com.madhoue.dsp.uadata.models.User;
import com.madhoue.dsp.uadata.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by miaohaifeng
 * on 2016/4/23.
 */
@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/addUser")
    public String addBasic(User obj) throws Exception {
        userService.addBasic(obj);
        return "success";
    }

    @RequestMapping(value = "/list")
    public String listUser(HttpServletRequest request) {

        List<User> list = userService.selectAll();
        for (User user : list) {
            System.out.println("---:" + user.getId());
        }
        request.setAttribute("userlist", list);
        return "listUser";
    }
}
