FROM azul/zulu-openjdk-alpine:11-jre
ARG JAR_FILE=build/libs/pipeline-report.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
