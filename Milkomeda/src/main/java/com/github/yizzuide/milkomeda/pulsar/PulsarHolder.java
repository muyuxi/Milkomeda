package com.github.yizzuide.milkomeda.pulsar;

import java.util.function.Function;

/**
 * PulsarHolder
 * Pulsar 静态资源引用类
 *
 * @author yizzuide
 * @since 1.0.0
 * @version 1.1.0
 * Create at 2019/04/30 15:47
 */
public class PulsarHolder {

    private static Function<Throwable, Object> errorCallback;

    private static Pulsar pulsar;

    static void setErrorCallback(Function<Throwable, Object> errorCallback) {
        PulsarHolder.errorCallback = errorCallback;
    }

    static void setPulsar(Pulsar pulsar) { PulsarHolder.pulsar = pulsar; }

    /**
     * 可抛出异常回调，外部可直接调用来触发设置的回调执行
     */
    public static Function<Throwable, Object> getErrorCallback() {
        return errorCallback;
    }

    /**
     * 获取Pulsar
     * @return Pulsar
     */
    public static Pulsar getPulsar() {
        return pulsar;
    }

    /**
     * 一个简洁的用于运行异步子线程方法，配合PulsarDeferredResult在控制器层完成高效耗时请求处理
     * @param pulsarRunner 异步运行器
     */
    public static void async(PulsarRunner pulsarRunner) {
        pulsar.asyncRun(pulsarRunner);
    }
}