FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-imovel.jar
ENTRYPOINT ["java", "-jar", "app-imovel.jar"]