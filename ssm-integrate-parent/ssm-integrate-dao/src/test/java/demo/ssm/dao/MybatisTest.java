package demo.ssm.dao;

import demo.ssm.mapper.UserMapper;
import demo.ssm.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/5/19 8:48 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-dao.xml")
public class MybatisTest {


    @Autowired
    private UserMapper userMapper;

    /**
     *
     * 6/5/19 8:51 PM
     */
    @Test
    public void seleteUserByIdTest() throws Exception {
        User user = userMapper.selectUserById(1L);
        System.out.println("user = " + user);
    }

}
