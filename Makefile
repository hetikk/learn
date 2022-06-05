.PHONY: jar-build tests-run env-start env-stop

NGINX_CONTAINER := learn-nginx
ELASTICSEARCH_CONTAINER := learn-elasticsearch
KIBANA_CONTAINER := learn-kibana
LOGSTASH_CONTAINER := learn-logstash

env-start:
	NGINX_CONTAINER=$(NGINX_CONTAINER) \
	ELASTICSEARCH_CONTAINER=$(ELASTICSEARCH_CONTAINER) \
	KIBANA_CONTAINER=$(KIBANA_CONTAINER) \
	LOGSTASH_CONTAINER=$(LOGSTASH_CONTAINER) \
	docker-compose up -d --remove-orphans

env-stop:
	NGINX_CONTAINER=$(NGINX_CONTAINER) \
	ELASTICSEARCH_CONTAINER=$(ELASTICSEARCH_CONTAINER) \
	KIBANA_CONTAINER=$(KIBANA_CONTAINER) \
	LOGSTASH_CONTAINER=$(LOGSTASH_CONTAINER) \
	docker-compose down -v

env-clean:
	@ docker rm -f $(NGINX_CONTAINER) $(ELASTICSEARCH_CONTAINER) $(KIBANA_CONTAINER) $(LOGSTASH_CONTAINER)

elasticsearch-setup-passwords:
	#docker exec -it learn-elasticsearch bash
	#./bin/elasticsearch-setup-passwords auto < <(echo y)

elasticsearch-disable-security:
	@ docker exec -it $(ELASTICSEARCH_CONTAINER) sed -i 's/xpack\.security\.enabled: true/xpack\.security\.enabled: false/' ./config/elasticsearch.yml

elasticsearch-restart:
	@ docker restart $(ELASTICSEARCH_CONTAINER)

logstash-disable-es-monitoring:
	@ docker exec -it $(LOGSTASH_CONTAINER) sed -i -r 's/^xpack\.monitoring\.elasticsearch\.hosts:/#\0/' ./config/logstash.yml

logstash-restart:
	@ docker restart $(LOGSTASH_CONTAINER)

kibana-generate-login-data:
	@ docker exec $(ELASTICSEARCH_CONTAINER) ./bin/elasticsearch-create-enrollment-token -s kibana
	@ docker exec $(KIBANA_CONTAINER) ./bin/kibana-verification-code

kibana-restart:
	@ docker restart $(KIBANA_CONTAINER)

elk-restart: elasticsearch-restart logstash-restart kibana-restart

nginx-reload-conf:
	@ docker exec -it $(NGINX_CONTAINER) nginx -s reload
