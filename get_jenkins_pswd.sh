#!/usr/bin/env bash
source config.sh

docker exec -it -uroot $JENKINS_NAME bash -c "cat var/jenkins_home/secrets/initialAdminPassword"
