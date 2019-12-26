/*
 * Copyright 1999-2019 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.chaosblade.exec.plugin.model;

import com.alibaba.chaosblade.exec.common.model.FrameworkModelSpec;
import com.alibaba.chaosblade.exec.common.model.matcher.MatcherSpec;
import com.alibaba.chaosblade.exec.plugin.ElasticsearchConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuqibin
 */
public class ElasticsearchModelSpec extends FrameworkModelSpec {

    @Override
    protected List<MatcherSpec> createNewMatcherSpecs() {
        ArrayList<MatcherSpec> matcherSpecs = new ArrayList<MatcherSpec>();
        matcherSpecs.add(new Elasticsearch56MatcherSepc());
        matcherSpecs.add(new Elasticsearch7MatcherSepc());
        matcherSpecs.add(new ElasticsearchTransportMatcherSepc());
        matcherSpecs.add(new ElaticsearchHostMatcherSpec());
        matcherSpecs.add(new ElaticsearchPortMatcherSpec());
        matcherSpecs.add(new ElaticsearchActionTypeMatcherSpec());
        return matcherSpecs;
    }

    @Override
    public String getTarget() {
        return ElasticsearchConstant.TARGET_NAME;
    }

    @Override
    public String getShortDesc() {
        return "elasticsearch experiment";
    }

    @Override
    public String getLongDesc() {
        return "elasticsearch experiment contains delay and exception by command and so on.";
    }

    @Override
    public String getExample() {
        return "elasticsearch --elasticsearch56 --transport --action \"indices:data/read/get\" --host x.x.x.x --port 9201 ";
    }
}
