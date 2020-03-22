FROM openjdk:8-jre-alpine

COPY target/library-0.0.1-SNAPSHOT.jar /library.jar
CMD java -jar library.jar
