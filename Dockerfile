FROM openjdk:11-oracle
ARG JAR_FILE="/build/libs/bo-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} backend.jar
ENTRYPOINT ["java","-jar", "backend.jar"]