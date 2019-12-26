package com.alibaba.chaosblade.exec.plugin;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuqibin
 */
public interface ElasticsearchConstant {


    String TARGET_NAME = "elasticsearch";

    String ELASTICSEARCH56 = "elasticsearch56";

    String ELASTICSEARCH7 = "elasticsearch7";

    String TRANSPORT = "transport";

    String HOST_MATCHER_NAME = "host";
    String PORT_MATCHER_NAME = "port";

    String ACTION_TYPE_MATCHER_NAME = "cmd";

    String GET_ADDRESS_METHOD = "getAddress";
    String GET_HOST_METHOD = "getHost";
    String GET_PORT_METHOD = "getPort";

    Map<String, Method> METHOD_MAP = new HashMap<String, Method>();

}
