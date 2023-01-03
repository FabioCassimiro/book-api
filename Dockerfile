FROM openjdk:8-jre
WORKDIR /app
COPY target/app/book-api.jar book-api.jar
ENTRYPOINT java -jar book-api.jar