package com.cneung.ssm.service.impl;

import com.cneung.ssm.mapper.RouteMapper;
import com.cneung.ssm.pojo.PageBean;
import com.cneung.ssm.pojo.Route;
import com.cneung.ssm.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/12/19 7:57 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 旅游线路业务层实现类
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteMapper routeMapper;


    @Override
    public Map routeCareChoose() {

        // 查询人气线路
        List<Route> popularityRoute = routeMapper.queryRouteOrderByCountDesc();
        // 查询最新线路
        List<Route> newsRoute = routeMapper.queryRouteOrderByRdateDesc();
        // 查询主题线路，按照时间降序
        List<Route> themesRoute = routeMapper.queryRouteByTsThemeTourOrderByRdateDesc();

        // 用于封装数据的 map
        Map<String, List<Route>> resultMap = new HashMap<>(16);
        resultMap.put("popularity", popularityRoute);
        resultMap.put("news", newsRoute);
        resultMap.put("themes", themesRoute);

        return resultMap;
    }

    @Override
    public PageBean findPageBean(Integer cid, Integer curPage, String rname) {

        // 定义页面大小
        int pageSize = 4;

        // 定义从第几条记录开始查询
        int firstResult = (curPage - 1) * pageSize;

        // 查询记录数
        int count = routeMapper.queryRouteCount(cid, rname);

        // 查询所有数据
        List<Route> routeList = routeMapper.queryRouteListPage(cid, firstResult, pageSize, rname);

        // 将查询出来的数据封装到 pageBean 中
        PageBean pageBean = new PageBean();
        // 当前页
        pageBean.setCurPage(curPage);
        // 页面大小
        pageBean.setPageSize(pageSize);
        // 总记录数
        pageBean.setCount(count);
        // 分页数据
        pageBean.setData(routeList);

        return null;
    }
}
