package com.baizhi.controller;

import com.baizhi.entity.Recom;
import com.baizhi.entity.Shops;
import com.baizhi.entity.User;
import com.baizhi.service.RecomService;
import com.baizhi.service.ShopsService;
import com.baizhi.service.UserService;
import com.baizhi.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 20:36
 * version : 1.0
 */
@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ShopsService shopsService;
    @Autowired
    private RecomService recomService;

    @RequestMapping("login")
    public String login(HttpServletRequest request, String username, String password){
        User user = userService.findByUsername(username);
        if (user!=null && user.getPassword().equals(password)){
            request.getSession().setAttribute("oneUser",user);
            request.getSession().setAttribute("theUser",userService.findOneById(user.getUserid()));
           // request.getSession().setAttribute("theRecoms",recomService.findByUserId(user.getUserid()));
            return "redirect:/User/findAll";
        }
        return "front/login";
    }

    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request){
        List<Shops> allShops = shopsService.findAll();
        request.getSession().setAttribute("theshops",allShops);
        return "front/shoplist";
    }

    @RequestMapping("findByName")
    public String findByName(HttpServletRequest request,String name){
        request.getSession().setAttribute("theshops",shopsService.findByName(name));
        return "front/shoplist";
    }

    @RequestMapping("addRecom")
    @ResponseBody
    public String addOneRecom(HttpServletRequest request,String name){
        User user = (User) request.getSession().getAttribute("oneUser");
        String uid = user.getUserid();
        //根据name查询是否有这个标签
        Recom recoms = recomService.findByUserIdAndName(uid,name);
        if (recoms!=null){
            //如果有则将其次数加一
            recomService.updateOne(recoms.getId(),null,recoms.getCounts()+1,null);
        }else {
            //如果没有则添加
            String id = MyUtils.getUUIDs();
            recomService.addOne(id,name,0,uid);
        }
        System.out.println(name);
        return null;
    }

    @RequestMapping("flashRecommend")
    @ResponseBody
    public List<Shops> findTheRecom(HttpServletRequest request){
       // User user = (User) request.getSession().getAttribute("oneUser");
        User user = userService.findByUsername("hr");
        System.out.println("用户"+user);
        String uid = user.getUserid();
        //用来做循环查询
        List<Recom> recoms = recomService.findTheFirsts(uid);
        System.out.println("用户的标签"+recoms);
        List<Shops> theshops = shopsService.findAll();
        System.out.println("所有商品"+theshops);
        List<Shops> shopsList = new ArrayList<>();
        for (Shops theshop : theshops) {
            for (Recom recom : recoms) {
                System.out.println("商品名"+theshop.getName());
                System.out.println("标签名"+recom.getName());
                if (theshop.getName()!=null && recom.getName()!=null && theshop.getName().equals(recom.getName())){
                    shopsList.add(theshop);
                }
            }
        }
        return shopsList;
    }


}
