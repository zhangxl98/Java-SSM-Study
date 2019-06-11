package com.cneung.ssm.mapper;

import com.cneung.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/11/19 10:04 AM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description
 */
public interface UserMapper {

    /**
     * 根据 username 查找 user
     * <pre>createTime:
     * 6/11/19 10:07 AM</pre>
     *
     * @param username
     * @return
     */
    User queryUserByUserName(@Param("username") String username);

    /**
     * 添加 user
     * <pre>createTime:
     * 6/11/19 10:08 AM</pre>
     *
     * @param user
     */
    void addUser(User user);

}
