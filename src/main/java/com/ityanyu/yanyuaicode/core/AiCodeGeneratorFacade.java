package com.ityanyu.yanyuaicode.core;

import com.ityanyu.yanyuaicode.ai.AiCodeGeneratorService;
import com.ityanyu.yanyuaicode.ai.model.HtmlCodeResult;
import com.ityanyu.yanyuaicode.ai.model.MultiFileCodeResult;
import com.ityanyu.yanyuaicode.exception.BusinessException;
import com.ityanyu.yanyuaicode.exception.ErrorCode;
import com.ityanyu.yanyuaicode.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.File;

/**
 * @author: dl
 * @Date: 2025/8/12
 * @Description: AI 代码生成门面类，组合生成和保存的功能
 **/
@Service
@Slf4j
public class AiCodeGeneratorFacade {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    /**
     * 统一入口：根据类型生成并保存代码
     *
     * @param userMessage     用户提示词
     * @param codeGenTypeEnum 生成类型
     * @return 保存的目录
     */
    public File generateAndSaveCode(String userMessage, CodeGenTypeEnum codeGenTypeEnum) {
        if (codeGenTypeEnum == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "生成类型为空");
        }
        return switch (codeGenTypeEnum) {
            case HTML -> generateAndSaveHtmlCode(userMessage);
            case MULTI_FILE -> generateAndSaveMultiFileCode(userMessage);
            default -> {
                String errorMessage = "不支持的生成类型：" + codeGenTypeEnum.getValue();
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
            }
        };
    }

    /**
     * 统一入口：根据类型生成并保存代码（流式）
     *
     * @param userMessage     用户提示词
     * @param codeGenTypeEnum 生成类型
     * @return 保存的目录
     */
    public Flux<String> generateAndSaveCodeStream(String userMessage, CodeGenTypeEnum codeGenTypeEnum) {
        if (codeGenTypeEnum == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "生成类型为空");
        }
        return switch (codeGenTypeEnum) {
            case HTML -> generateAndSaveHtmlCodeStream(userMessage);
            case MULTI_FILE -> generateAndSaveMultiFileCodeStream(userMessage);
            default -> {
                String errorMessage = "不支持的生成类型：" + codeGenTypeEnum.getValue();
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
            }
        };
    }

    /**
     * 生成并保存 HTML 代码文件（流式）
     *
     * @param userMessage 用户提示词
     * @return 保存的目录
     */
    private Flux<String> generateAndSaveHtmlCodeStream(String userMessage) {
        Flux<String> result = aiCodeGeneratorService.generateHtmlCodeStream(userMessage);
        //当流式放回生成代码后，再保存代码
        StringBuilder codeBuilder = new StringBuilder();
        return result.doOnNext(chunk ->{
            //实时收集代码块
            codeBuilder.append(chunk);
        }).doOnComplete(() -> {
            try {
                //流式输出完成，拼接成完整的代码
                String completeHtmlCode = codeBuilder.toString();
                HtmlCodeResult htmlCodeResult = CodeParser.parseHtmlCode(completeHtmlCode);
                //保存代码到文件
                File saveDir = CodeFileSaver.saveHtmlCodeResult(htmlCodeResult);
                log.info("文件保存成功，路径为：{}", saveDir.getAbsolutePath());
            }catch (Exception e){
                log.error("文件保存失败,{}", e.getMessage());
            }
        });
    }

    /**
     * 生成并保存多文件代码（流式）
     *
     * @param userMessage 用户提示词
     * @return 保存的目录
     */
    private Flux<String> generateAndSaveMultiFileCodeStream(String userMessage) {
        Flux<String> result = aiCodeGeneratorService.generateMultiFileCodeStream(userMessage);
        //当流式放回生成代码后，再保存代码
        StringBuilder codeBuilder = new StringBuilder();
        return result.doOnNext(chunk ->{
            //实时收集代码块
            codeBuilder.append(chunk);
        }).doOnComplete(() -> {
            try {
                //流式输出完成，拼接成完整的代码
                String completeMultiFileCode = codeBuilder.toString();
                MultiFileCodeResult multiFileCodeResult = CodeParser.parseMultiFileCode(completeMultiFileCode);
                //保存代码到文件
                File saveDir = CodeFileSaver.saveMultiFileCodeResult(multiFileCodeResult);
                log.info("文件保存成功，路径为：{}", saveDir.getAbsolutePath());
            }catch (Exception e){
                log.error("文件保存失败,{}", e.getMessage());
            }
        });
    }

    /**
     * 生成并保存 HTML 代码文件
     *
     * @param userMessage 用户提示词
     * @return 保存的目录
     */
    private File generateAndSaveHtmlCode(String userMessage) {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode(userMessage);
        return CodeFileSaver.saveHtmlCodeResult(result);
    }

    /**
     * 生成并保存多文件代码
     *
     * @param userMessage 用户提示词
     * @return 保存的目录
     */
    private File generateAndSaveMultiFileCode(String userMessage) {
        MultiFileCodeResult result = aiCodeGeneratorService.generateMultiFileCode(userMessage);
        return CodeFileSaver.saveMultiFileCodeResult(result);
    }
}


