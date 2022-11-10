FROM openjdk:11
ADD target/tradalarm-api-docker.jar tradalarm-api-docker.jar
ENTRYPOINT ["java", "-jar","tradalarm-api-docker.jar"]
EXPOSE 8082