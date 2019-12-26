package com.alibaba.chaosblade.exec.plugin.model;

import com.alibaba.chaosblade.exec.common.model.matcher.BasePredicateMatcherSpec;
import com.alibaba.chaosblade.exec.plugin.ElasticsearchConstant;

/**
 * @author yuqibin
 */
public class Elasticsearch56MatcherSepc extends BasePredicateMatcherSpec {
    @Override
    public String getName () {
        return ElasticsearchConstant.ELASTICSEARCH56;
    }

    @Override
    public String getDesc () {
        return "To tag elasticsearch5.x or 6.x experiment.";
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
