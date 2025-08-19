package com.ityanyu.yanyuaicode.core.saver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.ityanyu.yanyuaicode.constant.AppConstant;
import com.ityanyu.yanyuaicode.exception.BusinessException;
import com.ityanyu.yanyuaicode.exception.ErrorCode;
import com.ityanyu.yanyuaicode.model.enums.CodeGenTypeEnum;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author: dl
 * @Date: 2025/8/13
 * @Description: 抽象代码文件保存器--模板方法模式
 **/
public abstract class CodeFileSaverTemplate<T> {

    /**
     * 文件保存的根目录
     */
    private static final String FILE_SAVE_ROOT_DIR = AppConstant.CODE_OUTPUT_ROOT_DIR;


    /**
     * 模板方法，保存代码的标准流程
     *
     * @param result 代码结果对象
     * @return 保存的文件目录对象
     */
    public final File saveCode(T result,Long appId){
        //1.验证输入
        validateInput(result);
        //2.构建唯一目录
        String baseDirPath = buildUniqueDir(appId);
        //3.保存文件（由子类实现）
        saveFiles(result,baseDirPath);
        //4.返回文件目录对象
        return new File(baseDirPath);
    }

    /**
     * 验证参数输入 （可由子类重写）
     *
     * @param result 代码结果对象
     */
    protected void validateInput(T result) {
        if (result == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "代码结果对象不能为空");
        }
    }

    /**
     * 构建目录的唯一路径
     */
    private final String buildUniqueDir(Long appId) {
        String codeType = getCodeType().getValue();
        String uniqueDirName = StrUtil.format("{}_{}", codeType, appId);
        String dirPath = FILE_SAVE_ROOT_DIR + File.separator + uniqueDirName;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }


    /**
     * 写入单个文件的工具方法
     *
     * @param dirPath 目录路径
     * @param filename 文件名
     * @param content 文件内容
     */
    protected final void writeToFile(String dirPath, String filename, String content) {
        if (StrUtil.isNotBlank(content)){
            String filePath = dirPath + File.separator + filename;
            FileUtil.writeString(content,filePath, StandardCharsets.UTF_8);
        }
    }

    /**
     * 获取代码生成类型（子类实现）
     *
     * @return 代码生成类型
     */
    protected abstract CodeGenTypeEnum getCodeType();

    /**
     * 保存文件（由子类实现）
     *
     * @param result 代码结果对象
     * @param baseDirPath 目录的唯一路径
     */
    protected abstract void saveFiles(T result, String baseDirPath);

}
