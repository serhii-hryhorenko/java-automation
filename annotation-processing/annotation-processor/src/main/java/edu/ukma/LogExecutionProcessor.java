package edu.ukma;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class LogExecutionProcessor {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T obj) {
        return (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if (method.isAnnotationPresent(LogExecution.class)) {
                        System.out.println("Method " + method.getName() + " is called with args: " + Arrays.toString(args));
                    }
                    return method.invoke(obj, args);
                });
    }
}
