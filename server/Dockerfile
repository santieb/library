FROM openjdk:21-jdk

COPY target/server-0.0.1-SNAPSHOT.jar app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "app-0.0.1-SNAPSHOT.jar", "--spring.config.location=classpath:/application-docker.properties"]
