FROM maven:3-amazoncorretto-8
WORKDIR /book-api
COPY src src
COPY pom.xml pom.xml
RUN mvn package

FROM openjdk:8-jre

WORKDIR /app
COPY --from=0 /book-api/target/book-api.jar book-api.jar
ENTRYPOINT java -jar book-api.jar