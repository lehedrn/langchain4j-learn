package com.coderlee.multimodel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * LLMConfig 是一个 Spring 配置类，用于配置与大语言模型（LLM）相关的 Bean。
 * 该类通过读取配置文件中的属性值，初始化不同的聊天模型实例。
 * 
 * 这里采用了阿里百炼的平台，但是使用了两种不同的模型，来演示。实际应用中，可能不同模型来自于不同的平台提供的服务。
 */
@Configuration
public class LLMConfig {

    @Value("${llm.dashscope.api-key}")
    private String dashscopeApiKey;

    @Value("${llm.dashscope.default-model}")
    private String dashscopeDefaultModel;

    @Value("${llm.dashscope.base-url}")
    private String dashscopeBaseUrl;

    @Value("${llm.deepseek.default-model}")
    private String deepseekDefaultModel;

    /**
     * 创建并返回一个名为 "qwen" 的 OpenAiChatModel 实例。
     * 
     * @return OpenAiChatModel 配置了 DashScope API 密钥、基础 URL 和默认模型名称的聊天模型实例。
     * 
     * 该方法使用 DashScope 的配置参数构建 Qwen 模型实例。
     */
    @Bean("qwen")
    public OpenAiChatModel qwenChatModel() {
        // 使用 DashScope 的 API 密钥、基础 URL 和默认模型名称构建 Qwen 聊天模型
        return OpenAiChatModel.builder()
                .apiKey(this.dashscopeApiKey)
                .baseUrl(this.dashscopeBaseUrl)
                .modelName(this.dashscopeDefaultModel)
                .logRequests(true)
                .logResponses(true)
                .build();
    }

    /**
     * 创建并返回一个名为 "deepseek" 的 OpenAiChatModel 实例。
     * 
     * @return OpenAiChatModel 配置了 DashScope API 密钥、基础 URL 和 DeepSeek 默认模型名称的聊天模型实例。
     * 
     * 该方法使用 DashScope 的 API 密钥和基础 URL，结合 DeepSeek 的默认模型名称构建聊天模型实例。
     */
    @Bean("deepseek")
    public OpenAiChatModel deepseekChatModel() {
        // 使用 DashScope 的 API 密钥、基础 URL 和 DeepSeek 默认模型名称构建聊天模型
        return OpenAiChatModel.builder()
                .apiKey(this.dashscopeApiKey)
                .baseUrl(this.dashscopeBaseUrl)
                .modelName(this.deepseekDefaultModel)
                .logRequests(true)
                .logResponses(true)
                .build();
    }
}