FROM maven:3.8.2-jdk-8
RUN apt-get install curl
RUN curl -u admin:admin -o achat.jar "http://192.168.1.17:8081/repositories/maven-releases/tn/esprit/rh/achat/10.0/achat-10.0.jar
CMD mvn spring-boot:run
EXPOSE 8082
