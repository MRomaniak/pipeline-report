FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
RUN mkdir -p /app/
ARG JAR_FILE=build/libs/pipeline-report.jar
ADD ${JAR_FILE} /app/application.jar
ENTRYPOINT java -jar /app/application.jar
