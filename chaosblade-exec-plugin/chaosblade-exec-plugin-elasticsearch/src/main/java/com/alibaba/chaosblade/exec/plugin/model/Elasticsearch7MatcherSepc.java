package com.alibaba.chaosblade.exec.plugin.model;

import com.alibaba.chaosblade.exec.common.model.matcher.BasePredicateMatcherSpec;
import com.alibaba.chaosblade.exec.plugin.ElasticsearchConstant;

/**
 * @author yuqibin
 */
public class Elasticsearch7MatcherSepc extends BasePredicateMatcherSpec {
    @Override
    public String getName () {
        return ElasticsearchConstant.ELASTICSEARCH7;
    }

    @Override
    public String getDesc () {
        return "To tag elasticsearch7.x experiment.";
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
