package com.ityanyu.yanyuaicode.service;

/**
 * @author: dl
 * @Date: 2025/8/27
 * @Description: 截图服务接口
 **/
public interface ScreenshotService {
    /**
     * 通用的截图服务 返回访问地址
     *
     * @param webUrl
     * @return
     */
    String generateAndUploadScreenshot(String webUrl);
}
