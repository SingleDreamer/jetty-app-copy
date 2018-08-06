#!/usr/bin/env bash
source config.sh

# jenkins
# this has docker installed???
# docker run -d --name jenkins -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts
docker run -d \
  -p 8080:8080 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  --name $JENKINS_NAME \
  singledreamer/jenkins-with-plugins
  #gustavoapolinario/jenkins-docker
  #getintodevops/jenkins-withdocker:lts

# this allows docker to run inside the jenkins container (just in case? not sure why sometimes it needs this)
docker exec -it -uroot $JENKINS_NAME bash -c "chmod 777 /var/run/docker.sock"

#need to check if get jenkins password has output
#sleep 30s

./get_jenkins_pswd.sh

cd going_headless

python configure_jenkins_2.py
