.PHONY: nginx-start nginx-stop nginx-restart nginx-reload

NGINX_CONTAINER_NAME := learn-nginx

nginx-start:
	NGINX_CONTAINER_NAME=$(NGINX_CONTAINER_NAME) \
	docker-compose up -d

nginx-stop:
	NGINX_CONTAINER_NAME=$(NGINX_CONTAINER_NAME) \
	docker-compose down

nginx-restart: nginx-stop nginx-start

nginx-reload-conf:
	docker exec -it $(NGINX_CONTAINER_NAME) nginx -s reload
