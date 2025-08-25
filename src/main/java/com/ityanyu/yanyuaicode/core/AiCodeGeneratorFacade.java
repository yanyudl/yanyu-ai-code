package com.ityanyu.yanyuaicode.core;

import com.ityanyu.yanyuaicode.ai.AiCodeGeneratorService;
import com.ityanyu.yanyuaicode.ai.AiCodeGeneratorServiceFactory;
import com.ityanyu.yanyuaicode.ai.model.HtmlCodeResult;
import com.ityanyu.yanyuaicode.ai.model.MultiFileCodeResult;
import com.ityanyu.yanyuaicode.core.parser.CodeParserExecutor;
import com.ityanyu.yanyuaicode.core.saver.CodeFileSaverExecutor;
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
    private AiCodeGeneratorServiceFactory aiCodeGeneratorServiceFactory;

    /**
     * 统一入口：根据类型生成并保存代码
     *
     * @param userMessage     用户提示词
     * @param codeGenTypeEnum 生成类型
     * @return 保存的目录
     */
    public File generateAndSaveCode(String userMessage, CodeGenTypeEnum codeGenTypeEnum,Long appId) {
        if (codeGenTypeEnum == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "生成类型为空");
        }
        // 根据 appId 获得相应的 AI 服务实例
        AiCodeGeneratorService aiCodeGeneratorService = aiCodeGeneratorServiceFactory.getAiCodeGeneratorService(appId,codeGenTypeEnum);
        return switch (codeGenTypeEnum) {
            case HTML -> {
                HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode(userMessage);
                yield CodeFileSaverExecutor.executorSaver(result,CodeGenTypeEnum.HTML,appId);
            }
            case MULTI_FILE -> {
                MultiFileCodeResult result = aiCodeGeneratorService.generateMultiFileCode(userMessage);
                yield CodeFileSaverExecutor.executorSaver(result,CodeGenTypeEnum.MULTI_FILE,appId);
            }
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
    public Flux<String> generateAndSaveCodeStream(String userMessage, CodeGenTypeEnum codeGenTypeEnum,Long appId) {
        if (codeGenTypeEnum == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "生成类型为空");
        }
        // 根据 appId 获得相应的 AI 服务实例
        AiCodeGeneratorService aiCodeGeneratorService = aiCodeGeneratorServiceFactory.getAiCodeGeneratorService(appId,codeGenTypeEnum);
        return switch (codeGenTypeEnum) {
            case HTML ->{
                Flux<String> result = aiCodeGeneratorService.generateHtmlCodeStream(userMessage);
                yield processCodeStream(result, codeGenTypeEnum,appId);
            }
            case MULTI_FILE ->{
                Flux<String> result = aiCodeGeneratorService.generateMultiFileCodeStream(userMessage);
                yield processCodeStream(result, codeGenTypeEnum,appId);
            }
            case VUE_PROJECT -> {
                Flux<String> result = aiCodeGeneratorService.generateVueProjectCodeStream(appId,userMessage);
                yield processCodeStream(result, codeGenTypeEnum,appId);
            }
            default -> {
                String errorMessage = "不支持的生成类型：" + codeGenTypeEnum.getValue();
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
            }
        };
    }

    /**
     * 通用流式代码处理方法
     *
     * @param codeStream 代码流
     * @param codeGenType 代码生成类型
     * @return 流式响应
     */
    private Flux<String> processCodeStream(Flux<String> codeStream, CodeGenTypeEnum codeGenType,Long appId) {
        //当流式放回生成代码后，再保存代码
        StringBuilder codeBuilder = new StringBuilder();
        return codeStream.doOnNext(chunk ->{
            //实时收集代码块
            codeBuilder.append(chunk);
        }).doOnComplete(() -> {
            try {
                //流式输出完成，拼接成完整的代码
                String completeCode = codeBuilder.toString();
                Object parserResult = CodeParserExecutor.executeParser(completeCode, codeGenType);
                //保存代码到文件
                File saveDir = CodeFileSaverExecutor.executorSaver(parserResult, codeGenType,appId);
                log.info("文件保存成功，路径为：{}", saveDir.getAbsolutePath());
            }catch (Exception e){
                log.error("文件保存失败,{}", e.getMessage());
            }
        });
    }
}


