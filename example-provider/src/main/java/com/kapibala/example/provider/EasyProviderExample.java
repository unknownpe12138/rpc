package com.kapibala.example.provider;

import com.kapibala.example.common.service.UserService;
import com.kapibala.rpc.registry.LocalRegistry;
import com.kapibala.rpc.server.HttpServer;
import com.kapibala.rpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
