package com.coderlee.bootintegration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.langchain4j.model.chat.ChatModel;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * PopularIntegrationController 是一个 RESTful 控制器，用于处理与流行聊天模型的交互请求。
 * 该控制器通过 LangChain4J 提供的 ChatModel 实现与大语言模型的对话功能。
 * 
 * 低阶api，直接调用chatmodel，只要引入
 * <dependency>
 *    <groupId>dev.langchain4j</groupId>
 *   <artifactId>langchain4j-open-ai-spring-boot-starter</artifactId>
 *   <version>1.7.1-beta14</version>
 * </dependency>
 * 以及在配置文件中配置一下内容
 * langchain4j.open-ai.chat-model.api-key=${OPENAI_API_KEY}
 * langchain4j.open-ai.chat-model.model-name=xxx
 * langchain4j.open-ai.chat-model.log-requests=true
 * langchain4j.open-ai.chat-model.log-responses=true
 */
@RestController
@RequestMapping("popular") // 定义基础路径为 "/popular"
public class PopularIntegrationController {

    /**
     * ChatModel 是 LangChain4J 提供的核心接口，用于与聊天模型进行交互。
     * 使用 @Resource 注解将配置好的 ChatModel 实例注入到控制器中。
     */
    @Resource
    private ChatModel chatModel;

    /**
     * 处理用户发送的聊天请求。
     *
     * @param question 用户提出的问题，默认值为 "你是谁"。
     *                 如果用户未提供问题，则使用默认值。
     * @return 返回聊天模型对问题的回答。
     */
    @GetMapping("chat") // 定义 GET 请求路径为 "/popular/chat"
    public String chat(@RequestParam(defaultValue = "你是谁") String question) {
        // 调用 ChatModel 的 chat 方法，并返回结果
        return this.chatModel.chat(question);
    }
}
