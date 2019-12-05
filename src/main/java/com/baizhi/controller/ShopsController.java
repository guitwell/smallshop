package com.baizhi.controller;

import com.baizhi.entity.Category;
import com.baizhi.entity.Shops;
import com.baizhi.service.CategoryService;
import com.baizhi.service.ShopsService;
import com.baizhi.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 18:42
 * version : 1.0
 */
@Controller
@RequestMapping("Shops")
public class ShopsController {

    @Autowired
    private ShopsService shopsService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request){
        List<Shops> allShops = shopsService.findAll();
        request.getSession().setAttribute("allShops",allShops);
        return "back/main";
    }
    @RequestMapping("findOneById")
    public String findOneById(HttpServletRequest request,String id){
        List<Category> allCategorys = categoryService.findAllParent();
        request.getSession().setAttribute("allParentCate",allCategorys);
        request.getSession().setAttribute("theidShop",shopsService.findShopById(id));
        return "back/updateShops";
    }
    @RequestMapping("addOne")
    public String addOne(HttpServletRequest request,String name,Integer price,Integer count,
                         MultipartFile picture,String categoryid) throws Exception {
        String id = MyUtils.getUUIDs();
        String pictureName = picture.getOriginalFilename();
        //根据相对获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/imgs");
        //文件上传
        picture.transferTo(new File(realPath,pictureName));
        shopsService.addOne(id,name,price,count,pictureName,categoryid);
        return "redirect:/Shops/findAll";
    }
    @RequestMapping("updateOne")
    public String updateOne(HttpServletRequest request,String id,String name,Integer price,Integer count,
                            MultipartFile picture,String categoryid) throws IOException {
        Shops shops = shopsService.findShopById(id);
        //根据相对获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/imgs");
        //图片上传
        String thecover = null;
        if (picture.getOriginalFilename().length()>1) {
            //文件上传
            thecover = picture.getOriginalFilename();
            picture.transferTo(new File(realPath,thecover));
        }
        shopsService.updateOne(id,name,price,count,thecover,categoryid);
        return "redirect:/Shops/findAll";
    }

    @RequestMapping("findAllCates")
    public String findAllCates(HttpServletRequest request){
        List<Category> allCategorys = categoryService.findAllParent();
        request.getSession().setAttribute("allParentCate",allCategorys);
        return "back/addShops";
    }



}
