FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-coleta-lixo.jar
ENTRYPOINT ["java", "-jar", "app-coleta-lixo.jar"]