package com.baizhi.controller;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 19:35
 * version : 1.0
 */
@Controller
@RequestMapping("Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private Category category;

    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request){
        request.getSession().setAttribute("allCategorys",categoryService.findAllCategory());
        request.setAttribute("allParentCate",categoryService.findAllParent());
        return "back/addCate";
    }
    /*@RequestMapping("findAllParent")
    public String findAllParent(HttpServletRequest request){
        return null;
    }*/
    @RequestMapping("findAllSon")
    @ResponseBody
    public List<Category> findAllSon(HttpServletRequest request,String parentid){
        List<Category> soncategory = categoryService.findSonCategory(parentid);
        return soncategory;
    }

    @RequestMapping("addCategory")
    public String addOne(String name,Integer leval,String parentid){
        category.setId(MyUtils.getUUIDs());
        category.setName(name);
        category.setParentid(parentid);
        if (leval==null){leval=1;}
        category.setLeval(leval);
        categoryService.addOneCategory(category);
        return "redirect:/Category/findAll";
    }

}
