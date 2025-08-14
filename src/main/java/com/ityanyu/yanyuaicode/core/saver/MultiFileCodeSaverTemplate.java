package com.ityanyu.yanyuaicode.core.saver;

import cn.hutool.core.util.StrUtil;
import com.ityanyu.yanyuaicode.ai.model.MultiFileCodeResult;
import com.ityanyu.yanyuaicode.exception.BusinessException;
import com.ityanyu.yanyuaicode.exception.ErrorCode;
import com.ityanyu.yanyuaicode.model.enums.CodeGenTypeEnum;

/**
 * @author: dl
 * @Date: 2025/8/14
 * @Description: 多文件代码保存器
 **/
public class MultiFileCodeSaverTemplate extends CodeFileSaverTemplate<MultiFileCodeResult> {

    /**
     * 获取代码类型
     */
    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.MULTI_FILE;
    }

    /**
     *
     * @param result 代码结果对象
     * @param baseDirPath 目录的唯一路径
     */
    @Override
    protected void saveFiles(MultiFileCodeResult result, String baseDirPath) {
        // 保存 HTML 文件
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
        // 保存 CSS 文件
        writeToFile(baseDirPath, "style.css", result.getCssCode());
        // 保存 JS 文件
        writeToFile(baseDirPath, "script.js", result.getJsCode());
    }

    /**
     * 验证输入参数
     *
     * @param result 代码结果对象
     */
    @Override
    protected void validateInput(MultiFileCodeResult result) {
        super.validateInput(result);
        // 至少需要 HTML 代码，CSS 与 JS 可以为空
        if(StrUtil.isBlank(result.getHtmlCode())){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码不能为空");
        }
    }
}
