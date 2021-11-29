FROM openjdk:8-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/linkflix-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} linkflix.jar
ENTRYPOINT ["java", "-Dspring.config.location=/secret/application-prod.properties", "-jar", "linkflix.jar"]