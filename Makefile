.PHONY: jar-build tests-run env-start env-stop db-start db-stop db-ping

POSTGRES_IMAGE := postgres
POSTGRES_CONTAINER := learn-testcontainers
POSTGRES_HOST := localhost
POSTGRES_USER := learn
POSTGRES_PASSWORD := 123456
NOW := $(shell date '+%Y-%m-%d_%H:%M:%S')
TEMP_POSTGRES_DB_NAME := $(or $(POSTGRES_CONTAINER), "learn-postgres-$(NOW)")
POSTGRES_DB_NAME := $(shell echo $(TEMP_POSTGRES_DB_NAME) | sed "s/-/_/g")

jar-build:
	mvn clean package

tests-run:
	mvn test

env-start:
	POSTGRES_IMAGE=$(POSTGRES_IMAGE) \
	POSTGRES_CONTAINER=$(POSTGRES_CONTAINER) \
	POSTGRES_HOST=$(POSTGRES_HOST) \
	POSTGRES_USER=$(POSTGRES_USER) \
	POSTGRES_PASSWORD=$(POSTGRES_PASSWORD) \
	POSTGRES_DB_NAME=$(POSTGRES_DB_NAME) \
	docker-compose up -d

env-stop:
	POSTGRES_IMAGE=$(POSTGRES_IMAGE) \
	POSTGRES_CONTAINER=$(POSTGRES_CONTAINER) \
	POSTGRES_HOST=$(POSTGRES_HOST) \
	POSTGRES_USER=$(POSTGRES_USER) \
	POSTGRES_PASSWORD=$(POSTGRES_PASSWORD) \
	POSTGRES_DB_NAME=$(POSTGRES_DB_NAME) \
	docker-compose stop

db-start:
	POSTGRES_IMAGE=$(POSTGRES_IMAGE) \
	POSTGRES_CONTAINER=$(POSTGRES_CONTAINER) \
	POSTGRES_HOST=$(POSTGRES_HOST) \
	POSTGRES_USER=$(POSTGRES_USER) \
	POSTGRES_PASSWORD=$(POSTGRES_PASSWORD) \
	POSTGRES_DB_NAME=$(POSTGRES_DB_NAME) \
	docker-compose up -d postgres

db-stop:
	POSTGRES_IMAGE=$(POSTGRES_IMAGE) \
	POSTGRES_CONTAINER=$(POSTGRES_CONTAINER) \
	POSTGRES_HOST=$(POSTGRES_HOST) \
	POSTGRES_USER=$(POSTGRES_USER) \
	POSTGRES_PASSWORD=$(POSTGRES_PASSWORD) \
	POSTGRES_DB_NAME=$(POSTGRES_DB_NAME) \
	docker-compose stop postgres

db-ping:
	@ docker exec $(POSTGRES_CONTAINER) pg_isready --host=localhost --username=$(POSTGRES_USER) --dbname=$(POSTGRES_DB_NAME)