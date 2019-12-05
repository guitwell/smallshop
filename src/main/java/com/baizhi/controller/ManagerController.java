package com.baizhi.controller;

import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * author : 张京斗
 * create_date : 2019/10/31 22:05
 * version : 1.0
 */
@Controller
@RequestMapping("Manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("login")
    public String login(HttpServletRequest request,String username,String password){
       Manager manager = managerService.findOne(username);
        if (manager != null && manager.getPassword().equals(password)) {
            request.getSession().setAttribute("theManager",manager);
            return "redirect:/Shops/findAll";
        }
        return "back/login";
    }

}
