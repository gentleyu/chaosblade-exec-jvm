package com.alibaba.chaosblade.exec.plugin.elasticsearch56;

import com.alibaba.chaosblade.exec.common.aop.PointCut;
import com.alibaba.chaosblade.exec.common.aop.matcher.clazz.ClassMatcher;
import com.alibaba.chaosblade.exec.common.aop.matcher.clazz.NameClassMatcher;
import com.alibaba.chaosblade.exec.common.aop.matcher.method.MethodMatcher;
import com.alibaba.chaosblade.exec.common.aop.matcher.method.NameMethodMatcher;

/**
 * @author yuqibin
 */
public class Elaticsearch56TransportPointCut implements PointCut {

    private static final String CLASS_NAME = "org.elasticsearch.transport.TcpTransport";

    private static final String INTERCEPTOR_PRE_METHOD = "sendRequestToChannel";

    @Override
    public ClassMatcher getClassMatcher () {
        return new NameClassMatcher(CLASS_NAME);
    }

    @Override
    public MethodMatcher getMethodMatcher () {
        return new NameMethodMatcher(INTERCEPTOR_PRE_METHOD);
    }
}
