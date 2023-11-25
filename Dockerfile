
FROM openjdk:latest
COPY target/global-solution-0.0.1-SNAPSHOT.jar global-solution-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/global-solution-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
