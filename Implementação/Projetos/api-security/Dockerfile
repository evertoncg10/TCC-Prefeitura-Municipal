FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-auth.jar
ENTRYPOINT ["java", "-jar", "app-auth.jar" ]