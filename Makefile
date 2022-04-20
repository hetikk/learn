build-jar:
	mvn clean package

tests-run:
	mvn test

start-db:
	docker-compose up -d

stop-db:
	docker-compose stop