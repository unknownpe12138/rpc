package com.kapibala.example.provider;

import com.kapibala.example.common.service.UserService;
import com.kapibala.rpc.RpcApplication;
import com.kapibala.rpc.registry.LocalRegistry;
import com.kapibala.rpc.server.HttpServer;
import com.kapibala.rpc.server.VertxHttpServer;

public class ProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
