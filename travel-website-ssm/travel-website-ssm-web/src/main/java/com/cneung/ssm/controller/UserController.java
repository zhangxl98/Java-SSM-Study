package com.cneung.ssm.controller;

import com.cneung.ssm.exception.UserExistsException;
import com.cneung.ssm.exception.UserNameOrPasswordErrorException;
import com.cneung.ssm.exception.UserNoActiveException;
import com.cneung.ssm.pojo.ResultInfo;
import com.cneung.ssm.pojo.User;
import com.cneung.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
     * @param user    用户
     * @param check   验证码
     * @param session
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public ResultInfo register(User user, @RequestParam("check") String check, HttpSession session) {
        ResultInfo resultInfo;
        try {
            // 验证码校验，不区分大小写
            if (!check.equalsIgnoreCase((String) session.getAttribute("check"))) {
                resultInfo = new ResultInfo(false, null, "验证码错误！");
            } else {
                userService.register(user);
                resultInfo = new ResultInfo(true, null, null);
            }
        } catch (UserExistsException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器异常，请联系管理员！");
        }
        return resultInfo;
    }

    /**
     * 用户登录
     * <pre>createTime:
     * 6/12/19 10:02 AM</pre>
     *
     * @param user
     * @param check
     * @param session
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(User user, @RequestParam("check") String check, HttpSession session) {
        ResultInfo resultInfo;

        try {
            // 验证码校验，不区分大小写
            if (!check.equalsIgnoreCase((String) session.getAttribute("check"))) {
                resultInfo = new ResultInfo(false, null, "验证码错误！");
            } else {
                User queryUser = userService.login(user);
                resultInfo = new ResultInfo(true, null, null);
                // 把 user 存到域中
                session.setAttribute("user", queryUser);
            }
        } catch (UserNameOrPasswordErrorException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, e.getMessage());
        } catch (UserNoActiveException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器异常，请联系管理员！");
        }

        return resultInfo;
    }

    /**
     * 用户登录后，显示用户信息
     * <pre>createTime:
     * 6/12/19 7:42 PM</pre>
     *
     * @param session
     * @return
     */
    @RequestMapping("queryInfoByLoginUser")
    @ResponseBody
    public ResultInfo queryInfoByLoginUser(HttpSession session) {

        ResultInfo resultInfo;

        User loginUser = (User) session.getAttribute("user");

        if (null != loginUser) {
            // 用户已登录，响应用户名
            resultInfo = new ResultInfo(true, loginUser.getName(), null);
        } else {
            resultInfo = new ResultInfo(false, null, null);
        }

        return resultInfo;
    }

    /**
     * 用户退出登录
     * <pre>createTime:
     * 6/12/19 7:45 PM</pre>
     *
     * @param session
     * @return
     */
    @RequestMapping("loginOut")
    public String loginOut(HttpSession session) {
        // 销毁 session
        session.invalidate();

        // 重定向到登录页面
        return "redirect:/login.html";
    }
}
