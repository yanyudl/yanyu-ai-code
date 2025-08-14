package com.ityanyu.yanyuaicode.core.saver;

import com.ityanyu.yanyuaicode.ai.model.HtmlCodeResult;
import com.ityanyu.yanyuaicode.ai.model.MultiFileCodeResult;
import com.ityanyu.yanyuaicode.exception.BusinessException;
import com.ityanyu.yanyuaicode.exception.ErrorCode;
import com.ityanyu.yanyuaicode.model.enums.CodeGenTypeEnum;

import java.io.File;

/**
 * @author: dl
 * @Date: 2025/8/14
 * @Description: 文件保存执行器
 **/
public class CodeFileSaverExecutor {

    private static final HtmlCodeSaverTemplate htmlCodeSaverTemplate = new HtmlCodeSaverTemplate();

    private static final MultiFileCodeSaverTemplate multiFileCodeSaverTemplate = new MultiFileCodeSaverTemplate();

    /**
     * 执行代码保存
     * 执行文件保存
     *
     * @param result 代码结果对象
     * @param codeGenTypeEnum 代码生成类型
     * @return 保存的目录f
     */
    public static File executorSaver(Object result, CodeGenTypeEnum codeGenTypeEnum) {
        return switch (codeGenTypeEnum) {
            case HTML -> htmlCodeSaverTemplate.saveCode((HtmlCodeResult) result);
            case MULTI_FILE -> multiFileCodeSaverTemplate.saveCode((MultiFileCodeResult) result);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR,"不支持的代码生成类型");
        };
    }
}
