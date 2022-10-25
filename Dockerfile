FROM openjdk:8-jre-alpine
COPY target/achat-1.0.jar achat-1.0.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "achat-10.0.jar"]
