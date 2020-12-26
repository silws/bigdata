FROM openjdk:8
ADD target/dbserver-0.0.1-SNAPSHOT.jar dbserver-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "dbserver-0.0.1-SNAPSHOT.jar"]