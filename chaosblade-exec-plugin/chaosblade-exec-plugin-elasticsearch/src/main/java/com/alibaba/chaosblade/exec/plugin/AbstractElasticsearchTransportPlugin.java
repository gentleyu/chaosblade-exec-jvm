package com.alibaba.chaosblade.exec.plugin;

import com.alibaba.chaosblade.exec.common.aop.Plugin;
import com.alibaba.chaosblade.exec.common.model.ModelSpec;
import com.alibaba.chaosblade.exec.plugin.model.ElasticsearchModelSpec;

/**
 * @author yuqibin
 */
public abstract class AbstractElasticsearchTransportPlugin implements Plugin {

    @Override
    public ModelSpec getModelSpec() {
        return new ElasticsearchModelSpec();
    }
}
