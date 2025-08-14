package com.ityanyu.yanyuaicode.core.saver;

import cn.hutool.core.util.StrUtil;
import com.ityanyu.yanyuaicode.ai.model.HtmlCodeResult;
import com.ityanyu.yanyuaicode.exception.BusinessException;
import com.ityanyu.yanyuaicode.exception.ErrorCode;
import com.ityanyu.yanyuaicode.model.enums.CodeGenTypeEnum;

/**
 * @author: dl
 * @Date: 2025/8/14
 * @Description: HTML 代码保存器
 **/
public class HtmlCodeSaverTemplate extends CodeFileSaverTemplate<HtmlCodeResult>{
    /**
     * 获取代码类型
     */
    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.HTML;
    }

    /**
     * 保存文件
     *
     * @param result 代码结果对象
     * @param baseDirPath 目录的唯一路径
     */
    @Override
    protected void saveFiles(HtmlCodeResult result, String baseDirPath) {
        // 保存 HTML 代码
        writeToFile(baseDirPath, "index.html", result.getHtmlCode());
    }

    /**
     *  子类自定义校验逻辑
     *
     * @param result 代码结果对象
     */
    @Override
    protected void validateInput(HtmlCodeResult result) {
        super.validateInput(result);
        // HTML代码不能为空
        if (StrUtil.isBlank(result.getHtmlCode())) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码不能为空");
        }
    }
}
