package com.cneung.ssm.mapper;

import com.cneung.ssm.pojo.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/12/19 8:03 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description
 */
public interface RouteMapper {

    /**
     * 根据收藏数降序取 4 条
     * <pre>createTime:
     * 6/12/19 8:12 PM</pre>
     *
     * @return
     */
    List<Route> queryRouteOrderByCountDesc();

    /**
     * 根据时间降序取 4 条
     * <pre>createTime:
     * 6/12/19 8:12 PM</pre>
     *
     * @return
     */
    List<Route> queryRouteOrderByRdateDesc();

    /**
     * 查询主题线路根据时间降序取 4 条
     * <pre>createTime:
     * 6/12/19 8:13 PM</pre>
     *
     * @return
     */
    List<Route> queryRouteByTsThemeTourOrderByRdateDesc();

    /**
     * 查询记录数
     * <pre>createTime:
     * 6/15/19 9:00 PM</pre>
     *
     * @param cid
     * @param rname
     * @return
     */
    int queryRouteCount(@Param("cid") Integer cid, @Param("rname") String rname);

    /**
     * 查询分页数据
     * <pre>createTime:
     * 6/15/19 9:00 PM</pre>
     *
     * @param cid
     * @param firstResult
     * @param pageSize
     * @param rname
     * @return
     */
    List<Route> queryRouteListPage(@Param("cid") Integer cid, @Param("firstResult") int firstResult, @Param("pageSize") int pageSize, @Param("rname") String rname);
}
