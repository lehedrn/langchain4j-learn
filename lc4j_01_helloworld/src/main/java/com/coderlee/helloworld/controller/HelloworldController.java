package com.coderlee.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.langchain4j.model.chat.ChatModel;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloworldController 是一个RESTful风格的控制器，用于处理与聊天相关的HTTP请求。
 * 该控制器提供了以下功能：
 * 1. 接收用户输入的问题并通过聊天模型生成回答。
 * 2. 提供了一个默认问题“你是谁”，当用户未提供问题时将使用默认值。
 *
 * 主要依赖：
 * - ChatModel：用于处理聊天逻辑并生成回答。
 *
 * 请求路径：
 * - 基础路径为 "/helloworld"，所有方法均基于此路径。
 */
@RestController
@RequestMapping("helloworld")
public class HelloworldController {

    // 使用@Resource注解自动注入ChatModel实例，用于处理聊天逻辑
    @Resource
    private ChatModel chatModel;

    /**
     * 处理GET请求的接口方法。
     * URL路径为“/helloworld/chat”，支持通过查询参数传递问题。
     * 如果没有传递问题，默认值为“你是谁”。
     *
     * @param question 用户提出的问题，默认值为“你是谁”
     * @return 返回聊天模型生成的回答
     */
    @GetMapping("chat")
    public String chat(@RequestParam(defaultValue = "你是谁") String question) {
        // 调用chatModel的chat方法，传入用户问题并返回回答
        return this.chatModel.chat(question);
    }

}
