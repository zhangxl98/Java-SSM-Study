package com.cneung.ssm.service;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/12/19 7:56 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 旅游线路业务层接口
 */
public interface RouteService {

    /**
     * 返回精选数据（人气、最新、主题）
     * <pre>createTime:
     * 6/12/19 7:57 PM</pre>
     *
     * @return
     */
    Map routeCareChoose();
}
