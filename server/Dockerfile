FROM openjdk:17-jdk

WORKDIR /app

COPY target/server-0.0.1-SNAPSHOT.jar /app/server-0.0.1-SNAPSHOT.jar

EXPOSE 8082

CMD ["java", "-jar", "server-0.0.1-SNAPSHOT.jar"]