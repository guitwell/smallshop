package tests;

import org.junit.Test;

/**
 * author : 张京斗
 * create_date : 2019/11/6 20:25
 * version : 1.0
 */
public class UserTest extends BaseTest {

    @Test
    public void test1(){
        System.out.println(userService.findByUsername("hr"));
    }
    @Test
    public void test2(){
        System.out.println(userService.findOneById("1"));
    }
    @Test
    public void test3(){
        System.out.println(categoryService.findAllParent());
    }

}
