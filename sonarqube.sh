#!/usr/bin/env bash
source config.sh

docker run --name postgres \
            -e POSTGRES_PASSWORD=mysecretpassword \
            -v myvol:/data \
            -d postgres


IP="$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' postgres)"

#echo $IP

#default created database is used
docker run -d --name sonarqube \
                -p 9000:9000 -p 9092:9092 \
                -e SONARQUBE_JDBC_USERNAME=postgres \
                -e SONARQUBE_JDBC_PASSWORD=mysecretpassword \
                -e SONARQUBE_JDBC_URL=jdbc:postgresql://$IP/postgres \
                -v sonarqube-temp:/opt/sonarqube/temp \
                sonarqube:lts
# ??????
# docker run -d --name jenkins -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts
