FROM maven:latest
COPY . /usr/src/app
WORKDIR /usr/src/app

RUN apt-get update
RUN mvn clean package

ENTRYPOINT java -jar target/java-spa-backend-0.0.1-SNAPSHOT.jar