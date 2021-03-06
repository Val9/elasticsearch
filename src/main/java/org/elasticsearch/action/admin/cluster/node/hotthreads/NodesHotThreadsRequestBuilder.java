/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.action.admin.cluster.node.hotthreads;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.cluster.support.BaseClusterRequestBuilder;
import org.elasticsearch.client.ClusterAdminClient;
import org.elasticsearch.common.unit.TimeValue;

/**
 */
public class NodesHotThreadsRequestBuilder extends BaseClusterRequestBuilder<NodesHotThreadsRequest, NodesHotThreadsResponse> {

    public NodesHotThreadsRequestBuilder(ClusterAdminClient clusterClient) {
        super(clusterClient, new NodesHotThreadsRequest());
    }

    public NodesHotThreadsRequestBuilder setNodesIds(String... nodesIds) {
        request.nodesIds(nodesIds);
        return this;
    }

    public NodesHotThreadsRequestBuilder setThreads(int threads) {
        request.threads(threads);
        return this;
    }

    public NodesHotThreadsRequestBuilder setType(String type) {
        request.type(type);
        return this;
    }

    public NodesHotThreadsRequestBuilder setInterval(TimeValue interval) {
        request.interval(interval);
        return this;
    }

    @Override
    protected void doExecute(ActionListener<NodesHotThreadsResponse> listener) {
        client.nodesHotThreads(request, listener);
    }
}
