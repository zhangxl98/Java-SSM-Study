package com.cneung.ssm.service;

import com.cneung.ssm.pojo.User;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/11/19 10:28 AM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 用户服务层接口
 */
public interface UserService {
    /**
     * 用户注册
     * <pre>createTime:
     * 6/11/19 10:33 AM</pre>
     *
     * @param user
     * @throws Exception
     */
    void register(User user) throws Exception;
}
