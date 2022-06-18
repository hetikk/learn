.PHONY: env-start env-stop env-clean nginx-reload-conf

APP_CONTAINER := learn-remote-debugging-app

build-jar:
	mvn clean package

tests-run:
	mvn test

env-start:
	APP_CONTAINER=$(APP_CONTAINER) \
	docker-compose up -d --remove-orphans

env-stop:
	APP_CONTAINER=$(APP_CONTAINER) \
	docker-compose down -v

env-clean:
	@ docker rm -f $(APP_CONTAINER)