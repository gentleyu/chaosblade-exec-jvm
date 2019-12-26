package com.alibaba.chaosblade.exec.plugin;

import com.alibaba.chaosblade.exec.common.aop.BeforeEnhancer;
import com.alibaba.chaosblade.exec.common.aop.EnhancerModel;
import com.alibaba.chaosblade.exec.common.model.matcher.MatcherModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static com.alibaba.chaosblade.exec.plugin.ElasticsearchConstant.*;


/**
 * @author yuqibin
 */
public abstract class AbstractElasticsearchTransportEnhancer extends BeforeEnhancer {


    @Override
    public EnhancerModel doBeforeAdvice (ClassLoader classLoader, String className, Object object, Method method, Object[] methodArguments) throws Exception {
        Object action = methodArguments[3];
        if (!(action instanceof String)) {
            return null;
        }

        Object node = methodArguments[0];

        Method getAddressMethod = node.getClass().getMethod(GET_ADDRESS_METHOD);
        getAddressMethod.setAccessible(true);
        Object addressObject = invokeMethod(node, METHOD_MAP, GET_ADDRESS_METHOD, null);
        String host = (String) invokeMethod(addressObject, METHOD_MAP,GET_HOST_METHOD,null);
        Object port = invokeMethod(addressObject, METHOD_MAP,GET_PORT_METHOD,null);

        MatcherModel matcherModel = new MatcherModel();
        matcherModel.add(ElasticsearchConstant.ACTION_TYPE_MATCHER_NAME, (String) action);
        matcherModel.add(ElasticsearchConstant.HOST_MATCHER_NAME, host);
        matcherModel.add(ElasticsearchConstant.PORT_MATCHER_NAME, String.valueOf(port));
        matcherModel.add(ElasticsearchConstant.TRANSPORT,"true");

        postDoBeforeAdvice(matcherModel);
        return new EnhancerModel(classLoader, matcherModel);
    }

    public abstract void postDoBeforeAdvice(MatcherModel matcherModel);

    private Object invokeMethod (Object o, Map<String, Method> cacheMethod, String methodName,
                                 Class<?>[] agrsClass, Object... args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object result = null;
        if (null != cacheMethod) {
            Method method = cacheMethod.get(methodName);
            if (null == method) {
                method = o.getClass().getMethod(methodName, agrsClass);
                cacheMethod.put(methodName, method);
            }
            if (null != method) {
                method.setAccessible(true);
                result = method.invoke(o, args);
            }
        }
        return result;
    }
}
