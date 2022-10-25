# define base docker image
FROM openjdk:8-jre-alpine
ADD target/*.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "app.jar"]
