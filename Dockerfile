FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
COPY build/libs/pipeline-report.jar app.jar
ENTRYPOINT java -jar /app.jar
