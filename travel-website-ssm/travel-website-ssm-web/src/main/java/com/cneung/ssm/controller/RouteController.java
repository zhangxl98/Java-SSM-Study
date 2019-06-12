package com.cneung.ssm.controller;

import com.cneung.ssm.pojo.ResultInfo;
import com.cneung.ssm.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/12/19 7:49 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 旅游线路控制层
 */
@Controller
@RequestMapping("route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    /**
     * 返回精选数据（人气、最新、主题）
     * <pre>createTime:
     * 6/12/19 7:52 PM</pre>
     *
     * @return
     */
    @RequestMapping("routeCareChoose")
    @ResponseBody
    public ResultInfo routeCareChoose() {

        ResultInfo resultInfo;

        try {
            //  获取数据集合
            Map map = routeService.routeCareChoose();

            resultInfo = new ResultInfo(true, map, null);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器异常，请联系管理员！");
        }
        return resultInfo;
    }
}
