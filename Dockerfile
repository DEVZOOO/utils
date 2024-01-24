FROM openjdk:8-jdk-alpine

#WORKDIR /app

WORKDIR /var/jenkins_home

RUN ls -l

ADD ./build/libs/utils-1.0-SNAPSHOT.jar /volume1/app/utils.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /volume1/app/utils.jar