FROM openjdk:16
ADD target/spring-mysql-docker.jar spring-mysql-docker.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "spring-mysql-docker.jar"]
