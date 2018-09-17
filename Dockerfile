FROM openjdk:8-jdk-alpine

ADD target/ecs-demo-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xms100m -Xmx256m -jar", "/app.jar"]