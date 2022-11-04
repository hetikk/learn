.PHONY: env-start env-stop env-clean nginx-reload-conf

POSTGRES := learn-postgres

env-start:
	POSTGRES=$(POSTGRES) \
	docker-compose up -d --remove-orphans

env-stop:
	POSTGRES=$(POSTGRES) \
	docker-compose down -v

env-clean:
	@ docker rm -f $(POSTGRES)