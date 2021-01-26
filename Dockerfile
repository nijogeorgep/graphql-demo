FROM openjdk:latest

COPY /target/grapgql-1.0.0.SNAPSHOT.jar /app/bin/grpphql.jar

EXPOSE 8080

ENTRYPOINT["java","/app/bin/grpphql.jar"]