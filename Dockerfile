FROM maven:3.6.2-jdk-8 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM gcr.io/distroless/java  
COPY --from=build /usr/src/app/target/water-bucket-test-1.0-SNAPSHOT.jar /usr/app/water-bucket-test-1.0-SNAPSHOT.jar  
ENTRYPOINT ["java","-jar","/usr/app/water-bucket-test-1.0-SNAPSHOT.jar"]  
