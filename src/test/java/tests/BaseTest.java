package tests;

import com.baizhi.SmallShopApplication;
import com.baizhi.service.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author : 张京斗
 * create_date : 2019/10/31 20:31
 * version : 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmallShopApplication.class)
public class BaseTest {
    @Autowired
    public ManagerService managerService;
    @Autowired
    public ShopsService shopsService;
    @Autowired
    public UserService userService;
    @Autowired
    public RecomService recomService;
    @Autowired
    public CategoryService categoryService;

}
