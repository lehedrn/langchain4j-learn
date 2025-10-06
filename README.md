# LangChain4J Spring Boot 学习项目

本项目基于 Spring Boot，旨在学习和实践 [LangChain4J](https://github.com/langchain4j/langchain4j) 框架的相关功能。

## 项目特点

- 集成 LangChain4J，实现自然语言处理与大模型交互
- 基于 Spring Boot 快速开发
- 代码结构清晰，适合学习和二次开发

## 项目模块

### lc4j_01_helloworld

`lc4j_01_helloworld` 是一个入门级模块，展示了如何使用 LangChain4J 和 Spring Boot 构建一个简单的“Hello World”应用。该模块的主要功能包括：

- **基本配置**：
  - 配置 Spring Boot 应用以加载 LangChain4J 核心组件。
  - 使用 `application.yml` 或 `application.properties` 文件设置必要的参数（如 API 密钥、模型类型等）。

- **核心功能**：
  - 调用 LangChain4J 提供的接口，实现与大语言模型的简单交互。
  - 示例代码中包含了一个基础的 `HelloWorldService` 类，演示了如何发送请求并接收响应。

- **运行方式**：
  - 启动 Spring Boot 应用后，访问指定的 REST API 端点（如 `/api/hello`），即可触发与大模型的交互。
  - 在浏览器或者postman/apifox中发送请求 `http://localhost:18080/helloworld/chat`



## 快速开始

1. 克隆项目：
    ```bash
    git clone https://github.com/lehedrn/langchain4j-learn.git
    ```
2. 进入项目目录并构建：
    ```bash
    cd langchain4j_learn
    ./mvnw clean install
    ```
3. 运行项目：
    ```bash
    ./mvnw spring-boot:run
    ```

## 主要依赖

- Java 17+
- Spring Boot 3.x
- LangChain4J

## 参考资料

- [LangChain4J 官方文档](https://github.com/langchain4j/langchain4j)
- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)

## 许可证

本项目遵循 MIT 许可证。