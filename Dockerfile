FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
#FROM openjdk:11.0.2-jdk-stretch
COPY build/libs/buffer-problem-*-all.jar buffer-problem.jar
EXPOSE 8080
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar buffer-problem.jar