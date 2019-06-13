package com.cneung.ssm.service.impl;

import com.cneung.ssm.mapper.CategoryMapper;
import com.cneung.ssm.pojo.Category;
import com.cneung.ssm.service.CategoryService;
import com.cneung.ssm.utils.JedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/12/19 9:39 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 线路分类业务层实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String findAllCategory() throws JsonProcessingException {

        String jsonData;

        //  从 redis 缓存中取出数据
        jsonData = (String) redisTemplate.opsForValue().get("categoryList");

        // 判空
        if (StringUtils.isBlank(jsonData)) {
            // 缓存中不存在数据 ==> 从数据库中查询
            List<Category> categoryList = categoryMapper.queryAll();
            // 将查询到的数据转换为 json 字符串
            jsonData = new ObjectMapper().writeValueAsString(categoryList);
            // 将字符串存入 redis 缓存
            redisTemplate.opsForValue().set("categoryList", jsonData);
        }

        return jsonData;
    }
}
