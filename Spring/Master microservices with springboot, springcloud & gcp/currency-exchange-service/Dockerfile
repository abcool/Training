FROM openjdk:11

EXPOSE 8000

ADD target/currency-exchange-service-docker-maven.jar currency-exchange-service-docker-maven.jar

ENTRYPOINT ["java","-jar","currency-exchange-service-docker-maven.jar"]