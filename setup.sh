#!/usr/bin/env bash
source config.sh

docker run --name postgres \
            -e POSTGRES_PASSWORD=mysecretpassword \
            -v myvol:/data \
            -d postgres


POSTGRES_IP="$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' postgres)"

# default created database is used
docker run -d --name sonarqube \
                -p 9000:9000 -p 9092:9092 \
                -e SONARQUBE_JDBC_USERNAME=postgres \
                -e SONARQUBE_JDBC_PASSWORD=mysecretpassword \
                -e SONARQUBE_JDBC_URL=jdbc:postgresql://$POSTGRES_IP/postgres \
                -v sonarqube-temp:/opt/sonarqube/temp \
                sonarqube:lts


# jenkins
# this has docker installed???
# docker run -d --name jenkins -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts
docker run -d \
  -p 8080:8080 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  --name $JENKINS_NAME \
  gustavoapolinario/jenkins-docker
  #getintodevops/jenkins-withdocker:lts


# this allows docker to run inside the jenkins container
docker exec -it -uroot $JENKINS_NAME bash -c "chmod 777 /var/run/docker.sock"


# gitlab
docker run --detach \
    --hostname gitlab.example.com \
    --publish 443:443 --publish 30080:80 --publish 30022:22 \
    --name $GITLAB_NAME \
    --restart always \
    --volume /srv/gitlab/config:/etc/gitlab \
    --volume /srv/gitlab/logs:/var/log/gitlab \
    --volume /srv/gitlab/data:/var/opt/gitlab \
    gitlab/gitlab-ce:latest


# local docker registry
docker run -d -p 5000:5000 --restart=always --name $REGISTRY_NAME registry:2
