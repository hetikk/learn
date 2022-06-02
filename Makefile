.PHONY: jar-build tests-run env-start env-stop

ELASTICSEARCH_CONTAINER := learn-elasticsearch
ELASTICSEARCH_LEARN_USER := learn
ELASTICSEARCH_LEARN_USER_PASSWORD := 123456
ELASTICSEARCH_ELASTIC_USER_PASSWORD := 123456
KIBANA_CONTAINER := learn-kibana

jar-build:
	mvn clean package

tests-run:
	mvn test

env-start:
	docker-compose up -d --remove-orphans

env-stop:
	docker-compose stop

es-create-token:
	@ docker exec $(ELASTICSEARCH_CONTAINER) ./bin/elasticsearch-create-enrollment-token -s kibana

kibana-verification-code:
	@ docker exec $(KIBANA_CONTAINER) ./bin/kibana-verification-code

es-recreate-elastic-users-passwords:
	@ docker exec $(ELASTICSEARCH_CONTAINER) ./bin/elasticsearch-setup-passwords auto

es-ip:
	@ docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $(ELASTICSEARCH_CONTAINER)


