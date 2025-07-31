package com.ityanyu.yanyuaicode.controller;

import com.ityanyu.yanyuaicode.common.BaseResponse;
import com.ityanyu.yanyuaicode.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dl
 * @Date: 2025/7/30
 * @Description: 健康检查接口
 **/
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success("ok");
    }
}