FROM openjdk:18-jdk-alpine3.15

RUN addgroup -S application && adduser -S application -G application

USER application

WORKDIR /home/application

RUN mkdir logs

COPY target/random_chat-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
