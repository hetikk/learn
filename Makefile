.PHONY: env-start env-stop env-clean nginx-reload-conf

NGINX_CONTAINER := learn-nginx

env-start:
	NGINX_CONTAINER=$(NGINX_CONTAINER) \
	docker-compose up -d --remove-orphans

env-stop:
	NGINX_CONTAINER=$(NGINX_CONTAINER) \
	docker-compose down -v

env-clean:
	@ docker rm -f $(NGINX_CONTAINER)

nginx-reload-conf:
	@ docker exec -it $(NGINX_CONTAINER) nginx -s reload