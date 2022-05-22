FROM amazoncorretto:17-alpine3.14-jdk
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG MAVEN_VERSION=3.8.5
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]