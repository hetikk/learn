package com.github.hetikk.learn;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.CreateResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.SneakyThrows;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

public class Application {

    @SneakyThrows
    public static void main(String[] args) {
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();

        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        ElasticsearchClient client = new ElasticsearchClient(transport);

        CreateRequest<Object> createRequest = new CreateRequest.Builder<>()
                .index("blog")
                .document("")
                .build();
        CreateResponse createResponse = client.create(createRequest);

        for (Hit<?> hit : search.hits().hits()) {
            System.out.println(hit.source());
        }
    }

}
