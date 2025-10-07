package com.coderlee.bootintegration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderlee.bootintegration.service.QwenChatAssistant;

import jakarta.annotation.Resource;

/**
 * DeclarativeAIServiceController 是一个基于声明式 AI 服务的 RESTful 控制器。
 * 提供了与 QwenChatAssistant 集成的能力，用于处理用户提问并返回智能回复。
 */
@RestController
@RequestMapping("declarative")
public class DeclarativeAIServiceController {

    @Resource
    private QwenChatAssistant qwenChatAssistant;

    /**
     * 处理 GET 请求，接收用户提问并返回聊天结果。
     *
     * @param question 用户提出的问题，默认值为 "你是谁"。
     * @return 返回调用 [QwenChatAssistant.chat] 方法后的回复字符串。
     */
    @GetMapping("chat")
    public String chat(@RequestParam(defaultValue = "你是谁") String question) {
        return this.qwenChatAssistant.chat(question);
    }
}
