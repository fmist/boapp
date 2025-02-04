FROM adoptopenjdk/openjdk11
ARG JAR_FILE="/build/libs/bo-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]