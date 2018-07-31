#!/usr/bin/env bash

source config.sh

docker stop postgres sonarqube $JENKINS_NAME $GITLAB_NAME $REGISTRY_NAME
docker rm postgres sonarqube $JENKINS_NAME $GITLAB_NAME $REGISTRY_NAME
