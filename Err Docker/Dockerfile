FROM ubuntu:latest
WORKDIR /app
RUN apt -y update
RUN apt install -y net-tools inetutils-ping
RUN apt install -y openjdk-21-jdk
RUN mkdir /app4
COPY ChatServer.jar /app4/
