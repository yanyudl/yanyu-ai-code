package com.ityanyu.yanyuaicode.service;

import com.ityanyu.yanyuaicode.model.dto.app.AppQueryRequest;
import com.ityanyu.yanyuaicode.model.entity.App;
import com.ityanyu.yanyuaicode.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;

import java.util.List;

/**
 *  服务层。
 *
 * @author <a href="https://github.com/yanyu">烟雨</a>
 */
public interface AppService extends IService<App> {

    /**
     * 脱敏并查询用户信息
     *
     * @param app
     * @return
     */
    AppVO getAppVO(App app);

    /**
     * 构造查询对象
     *
     * @param appQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 批量脱敏并查询用户信息
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);
}