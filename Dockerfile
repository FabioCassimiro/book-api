FROM maven:3-amazoncorretto-8
WORKDIR /book-api
COPY src src
COPY pom.xml pom.xml
RUN mvn package
RUN ls target
RUN pwd
FROM openjdk:8-jre

ARG VERSION
WORKDIR /app
COPY --from=0 /book-api/target/book-api-${VERSION}.jar book-api.jar
ENTRYPOINT java -jar book-api.jar