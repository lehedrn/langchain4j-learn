package com.coderlee.multimodel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.langchain4j.model.chat.ChatModel;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * MultiModelController 是一个多模型控制器，用于处理不同聊天模型的请求。
 * 该类通过 RESTful API 提供对 Qwen 和 Deepseek 聊天模型的访问接口。
 */
@RestController
@RequestMapping("multi-model")
public class MultiModelController {

    @Resource(name = "qwen")
    private ChatModel qwenChatModel;

    @Resource(name = "deepseek")
    private ChatModel deepseekChatModel;

    /**
     * 处理 Qwen 聊天模型的请求。
     *
     * @param question 用户提出的问题，默认值为 "你是谁"。
     *                 如果用户未提供问题，则使用默认值。
     * @return 返回 Qwen 聊天模型对问题的回答。
     */
    @GetMapping("qwen/chat")
    public String qwenChat(@RequestParam(defaultValue = "你是谁") String question) {
        // 调用 Qwen 聊天模型并返回结果
        return this.qwenChatModel.chat(question);
    }

    /**
     * 处理 Deepseek 聊天模型的请求。
     *
     * @param question 用户提出的问题，默认值为 "你是谁"。
     *                 如果用户未提供问题，则使用默认值。
     * @return 返回 Deepseek 聊天模型对问题的回答。
     */
    @GetMapping("deepseek/chat")
    public String deepseekChat(@RequestParam(defaultValue = "你是谁") String question) {
        // 调用 Deepseek 聊天模型并返回结果
        return this.deepseekChatModel.chat(question);
    }
}