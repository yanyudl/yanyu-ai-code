package com.ityanyu.yanyuaicode.core.parser;

import com.ityanyu.yanyuaicode.exception.BusinessException;
import com.ityanyu.yanyuaicode.exception.ErrorCode;
import com.ityanyu.yanyuaicode.model.enums.CodeGenTypeEnum;

/**
 * @author: dl
 * @Date: 2025/8/13
 * @Description: 代码解析器执行器
 **/
public class CodeParserExecutor {

    private static final HtmlCodeParser htmlCodeParser = new HtmlCodeParser();

    private static final MultiFileCodeParser multiFileCodeParser = new MultiFileCodeParser();

    /**
     * 执行代码解析器
     *
     * @param codeContent 代码内容
     * @param codeGenType 代码生成类型
     * @return 解析结果
     */
    public static Object executeParser(String codeContent, CodeGenTypeEnum codeGenType) {
        return switch (codeGenType) {
            case HTML -> htmlCodeParser.parserCode(codeContent);
            case MULTI_FILE -> multiFileCodeParser.parserCode(codeContent);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型:" + codeGenType);
        };
    }
}
