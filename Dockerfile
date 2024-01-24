FROM openjdk:8-jdk-alpine

#WORKDIR /app

RUN echo "PWD is $PWD"

#WORKDIR /volume1/app

RUN ls -l

ADD ./build/libs/utils-1.0-SNAPSHOT.jar /volume1/app/utils.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /volume1/app/utils.jar