FROM maven:3.6.3-jdk-8 as builder
COPY ./ ./
RUN mvn package && pwd && ls
FROM adoptopenjdk/openjdk8:latest
COPY --from=builder /target/backend.jar /opt/backend.jar
ENTRYPOINT ["java","-jar","-Dserver.port=9090","/opt/backend.jar"]