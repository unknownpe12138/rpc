package com.kapibala.example.provider;

import com.kapibala.example.common.service.UserService;
import com.kapibala.rpc.RpcApplication;
import com.kapibala.rpc.config.RegistryConfig;
import com.kapibala.rpc.config.RpcConfig;
import com.kapibala.rpc.model.ServiceMetaInfo;
import com.kapibala.rpc.registry.LocalRegistry;
import com.kapibala.rpc.registry.Registry;
import com.kapibala.rpc.registry.RegistryFactory;
import com.kapibala.rpc.server.HttpServer;
import com.kapibala.rpc.server.VertxHttpServer;

public class ProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
