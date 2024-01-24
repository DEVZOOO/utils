FROM openjdk:17-jdk-alpine

WORKDIR /volume1/app

ADD ./build/libs/utils-0.0.1-SNAPSHOT.jar /volume1/app/utils.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /volume1/app/utils.jar