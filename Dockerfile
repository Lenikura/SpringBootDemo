FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/SpringBootDemo-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ARG SPRING_PROFILE=dev

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -Dspring.profiles.active=${SPRING_PROFILE} -jar /app.jar"]