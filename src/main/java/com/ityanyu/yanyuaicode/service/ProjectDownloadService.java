package com.ityanyu.yanyuaicode.service;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author: dl
 * @Date: 2025/9/2
 * @Description: 项目下载接口
 **/
public interface ProjectDownloadService {

    /**
     * 下载项目为 zip
     *
     * @param projectPath 项目路径
     * @param downloadFileName 下载文件名
     * @param response
     */
    void downloadProjectAsZip(String projectPath, String downloadFileName, HttpServletResponse response);
}
