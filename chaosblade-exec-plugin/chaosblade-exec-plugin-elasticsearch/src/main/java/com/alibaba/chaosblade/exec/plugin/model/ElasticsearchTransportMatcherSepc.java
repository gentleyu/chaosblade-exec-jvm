package com.alibaba.chaosblade.exec.plugin.model;

import com.alibaba.chaosblade.exec.common.model.matcher.BasePredicateMatcherSpec;
import com.alibaba.chaosblade.exec.plugin.ElasticsearchConstant;

/**
 * @author yuqibin
 */
public class ElasticsearchTransportMatcherSepc extends BasePredicateMatcherSpec {
    @Override
    public String getName () {
        return ElasticsearchConstant.TRANSPORT;
    }

    @Override
    public String getDesc () {
        return "To tag transport api experiment.";
    }

    @Override
    public boolean noArgs () {
        return true;
    }

    @Override
    public boolean required () {
        return false;
    }
}
