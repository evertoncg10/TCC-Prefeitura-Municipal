FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-stur.jar
ENTRYPOINT ["java", "-jar", "app-stur.jar"]