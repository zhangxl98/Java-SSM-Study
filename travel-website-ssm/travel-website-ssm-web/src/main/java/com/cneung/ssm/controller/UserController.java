package com.cneung.ssm.controller;

import com.cneung.ssm.exception.UserExistsException;
import com.cneung.ssm.pojo.ResultInfo;
import com.cneung.ssm.pojo.User;
import com.cneung.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/11/19 10:57 AM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 用户控制层
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * <pre>createTime:
     * 6/11/19 11:14 AM</pre>
     *
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public ResultInfo register(User user) {
        ResultInfo resultInfo;
        try {
            userService.register(user);
            resultInfo = new ResultInfo(true,null,null);
        } catch (UserExistsException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"服务器异常，请联系管理员！");
        }
        return resultInfo;
    }
}
