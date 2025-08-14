package com.ityanyu.yanyuaicode.core.parser;

/**
 * @author: dl
 * @Date: 2025/8/13
 * @Description: 代码解析策略接口  策略模式
 **/
public interface CodeParser<T> {

    /**
     * 解析代码内容
     *
     * @param codeContent 原始代码内容
     * @return 解析后的对象结果
     */
    T parserCode(String codeContent);
}
