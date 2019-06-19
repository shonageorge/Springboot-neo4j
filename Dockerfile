FROM openjdk:11-jdk-stretch
ADD /target/springboot-noe4j-0.0.1-SNAPSHOT.jar src/app/springboot-noe4j-0.0.1-SNAPSHOT.jar
WORKDIR /src/app
ENTRYPOINT ["java","-jar","springboot-noe4j-0.0.1-SNAPSHOT.jar"]

