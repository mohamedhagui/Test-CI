FROM openjdk:8-jre-alpine
COPY target/achat-1.0.jar achat-1.0.jar
EXPOSE 8089
<<<<<<< HEAD
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
=======
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
>>>>>>> 2c99726f5f61fe0c8d64dbe6140ce87c9b5edd7d
