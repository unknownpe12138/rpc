package com.kapibala.rpc.fault.tolerant;

import com.kapibala.rpc.model.RpcResponse;

import java.util.Map;

/**
 * 降级到其他服务 - 容错策略
 */
public class FailBackTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        return null;
    }
}
