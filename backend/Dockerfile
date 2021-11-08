FROM openjdk:8-alpine
## LABEL maintainer="chaeha93@gmail.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/linkflix-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} linkflix.jar
ENTRYPOINT ["java", "-jar", "linkflix.jar"]