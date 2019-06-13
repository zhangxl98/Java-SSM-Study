package com.cneung.ssm.mapper;

import com.cneung.ssm.pojo.Category;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/13/19 8:52 AM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description
 */
public interface CategoryMapper {

    /**
     * 查询所有的分类
     * <pre>createTime:
     * 6/13/19 9:02 AM</pre>
     *
     * @return
     */
    List<Category> queryAll();
}
