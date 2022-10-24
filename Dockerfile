# define base docker image
FROM openjdk:8-jre-alpine
ADD target/*.jar achat.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat.jar"]
