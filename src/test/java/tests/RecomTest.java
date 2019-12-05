package tests;

import com.baizhi.entity.Recom;
import com.baizhi.entity.Shops;
import com.baizhi.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/7 8:30
 * version : 1.0
 */
public class RecomTest extends BaseTest{

    @Test
    public void test1(){
        User user = userService.findByUsername("hr");
        String uid = user.getUserid();
        //用来做循环查询
        List<Recom> recoms = recomService.findTheFirsts(uid);
        List<Shops> theshops = shopsService.findAll();
        List<Shops> shopsList = new ArrayList<>();
        for (Shops theshop : theshops) {
            for (Recom recom : recoms) {
                if (theshop.getName().equals(recom.getName())){
                    shopsList.add(theshop);
                }
            }
        }
        System.out.println(shopsList);
    }
    @Test
    public void test3(){
        recomService.updateOne("461a377e77224aebb3932a33fd5a1ba6",null,3,null);
    }

}
