package com.kapibala.example.consumer;

import com.kapibala.example.common.model.User;
import com.kapibala.example.common.service.UserService;
import com.kapibala.rpc.config.RpcConfig;
import com.kapibala.rpc.proxy.ServiceProxyFactory;
import com.kapibala.rpc.utils.ConfigUtils;

/**
 * 简易服务消费者示例
 *
 */
public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);

        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("hello kapibala!");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNumber();
        System.out.println(number);
    }
}

