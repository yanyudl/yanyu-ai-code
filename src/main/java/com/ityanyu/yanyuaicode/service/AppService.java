package com.ityanyu.yanyuaicode.service;

import com.ityanyu.yanyuaicode.model.dto.app.AppQueryRequest;
import com.ityanyu.yanyuaicode.model.entity.App;
import com.ityanyu.yanyuaicode.model.entity.User;
import com.ityanyu.yanyuaicode.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 *  服务层。
 *
 * @author <a href="https://github.com/yanyu">烟雨</a>
 */
public interface AppService extends IService<App> {

    /**
     * 通过对话生成代码
     *
     * @param appId 应用 ID
     * @param message 提示词
     * @param loginUser 当前登录用户
     * @return 流式输出
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

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