FROM adoptopenjdk/openjdk8:alpine-jre
MAINTAINER Sergey Nemchinov "googoodemon@gmail.com"

COPY ./target/*.jar /
EXPOSE 8080/tcp

ENTRYPOINT java -jar id-generator.jar
