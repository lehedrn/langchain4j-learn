package com.coderlee.bootintegration.service;

import dev.langchain4j.service.spring.AiService;

/**
 * QwenChatAssistant 是一个基于 AI 的聊天服务接口。
 * 使用了 LangChain4j 提供的 @AiService 注解进行声明，该接口将自动生成一个实现类，并使用 LangChain4j 提供的 AI 服务进行对话。
 * <p>
 * <code>@AiService</code> 可以将其视为标准的 Spring Boot @Service，但具有 AI 功能。
 * </p>
 */
@AiService
public interface QwenChatAssistant {

    /**
     * 处理用户提问并返回回答的字符串。
     *
     * @param question 用户提出的问题
     * @return 返回针对问题的回复字符串
     */
    String chat(String question);
}