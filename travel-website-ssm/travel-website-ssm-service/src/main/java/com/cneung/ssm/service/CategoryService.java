package com.cneung.ssm.service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/12/19 9:32 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 线路分类业务层接口
 */
public interface CategoryService {

    /**
     * 获取所有分类
     * <pre>createTime:
     * 6/12/19 9:39 PM</pre>
     *
     * @return
     */
    String findAllCategory() throws JsonProcessingException;
}
