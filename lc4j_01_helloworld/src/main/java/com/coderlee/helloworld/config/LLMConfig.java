package com.coderlee.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * 配置类用于设置与大型语言模型（LLM）相关的 Bean。
 * 
 * <p>该类是一个 Spring 配置类，标注了 {@code @Configuration} 注解，用于定义和初始化应用程序中
 * 所需的 LLM 相关组件。当前实现中，主要配置了一个基于 OpenAI 兼容模式的聊天模型实例。
 * 
 * <p>主要功能包括：
 * <ul>
 *   <li>通过 {@code chatModel()} 方法创建并配置一个 {@code OpenAiChatModel} 实例。</li>
 *   <li>支持从环境变量中动态获取 API 密钥，确保安全性与灵活性。</li>
 *   <li>提供对特定模型（如 "qwen-plus"）的支持，并允许自定义基础 URL。</li>
 * </ul>
 */
@Configuration
public class LLMConfig {

    /**
     * 创建并返回一个配置好的 OpenAiChatModel 实例。
     * 
     * <p>该方法通过以下步骤构建 OpenAiChatModel 对象：
     * <ul>
     *   <li>从环境变量 "DASHSCOPE_API" 中获取 API 密钥。</li>
     *   <li>设置基础 URL 为 "https://dashscope.aliyuncs.com/compatible-mode/v1"。</li>
     *   <li>指定模型名称为 "qwen-plus"。</li>
     * </ul>
     * 
     * @return 配置完成的 OpenAiChatModel 实例，用于与指定的聊天模型进行交互。
     */
    @Bean
    public OpenAiChatModel chatModel() {
        // 使用 OpenAiChatModel 的构建器模式创建实例
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("DASHSCOPE_API")) // 从环境变量中获取 API 密钥
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1") // 设置基础 URL
                .modelName("qwen-plus") // 指定模型名称
                .build(); // 构建并返回配置完成的实例
    }
}
