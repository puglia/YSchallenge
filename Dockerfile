FROM openjdk:13-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/challenge-0.0.1-SNAPSHOT.jar
ENV FILES_PATH=/var/www/ys
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dcustom.basepath.default=${FILES_PATH}","-jar","/app.jar"]