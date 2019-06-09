package demo.ssm.service;

import demo.ssm.pojo.User;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/6/19 10:29 AM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description
 */
public interface UserService {
    User findUserById(Long id);
}
