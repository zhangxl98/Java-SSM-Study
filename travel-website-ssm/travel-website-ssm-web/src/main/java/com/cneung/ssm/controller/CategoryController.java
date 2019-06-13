package com.cneung.ssm.controller;

import com.cneung.ssm.pojo.ResultInfo;
import com.cneung.ssm.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/12/19 9:18 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 线路分类控制层
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("findAllCategory")
    @ResponseBody
    public String findAllCategory() {
        String jsonData = null;

        try {
            jsonData = categoryService.findAllCategory();
        } catch (Exception e) {
            e.printStackTrace();
            ResultInfo resultInfo = new ResultInfo(false, null, "服务器异常，请联系管理员！");
            try {
                jsonData = new ObjectMapper().writeValueAsString(resultInfo);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }

        return jsonData;
    }
}
