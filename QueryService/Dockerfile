FROM openjdk:8

RUN mkdir /app
COPY target/GraphQLPOC-0.0.1-SNAPSHOT.jar /app

ENV TZ="Asia/Colombo"

WORKDIR /app

CMD ["java", "-jar", "GraphQLPOC-0.0.1-SNAPSHOT.jar"]