FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar amigosCode.jar
ENTRYPOINT ["java","-jar","/amigosCode.jar"]
EXPOSE 8080