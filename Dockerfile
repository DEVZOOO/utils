FROM openjdk:8-jdk-alpine
WORKDIR /app
ADD ./build/libs/utils-1.0-SNAPSHOT.jar /app/utils.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /app/utils.jar