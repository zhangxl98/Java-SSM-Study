import demo.ssm.pojo.User;
import demo.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/9/19 1:40 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 测试 service 层
     * 6/9/19 1:41 PM
     */
    @Test
    public void findByIdTest() throws Exception {
        User user = userService.findUserById(2L);
        System.out.println("user = " + user);
    }

}
