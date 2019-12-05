package tests;

import com.baizhi.entity.Shops;
import org.junit.Test;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 19:10
 * version : 1.0
 */
public class ShopsTests extends BaseTest{

    @Test
    public void test1(){
        List<Shops> shops = shopsService.findAll();
        for (Shops shop : shops) {
            System.out.println(shop);
        }
    }
    @Test
    public void test2(){
        System.out.println(shopsService.findShopById("1"));
    }
    @Test
    public void test3(){
        System.out.println(shopsService.findByName("瓜"));
    }

}
