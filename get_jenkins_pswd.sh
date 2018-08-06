#!/usr/bin/bash
source config.sh

echo "running get jenkins password"

initialAdminPassword="$(docker exec -it -uroot $JENKINS_NAME bash -c "cat var/jenkins_home/secrets/initialAdminPassword")"

while [ "$initialAdminPassword" = "cat: var/jenkins_home/secrets/initialAdminPassword: No such file or directory" ]; do
initialAdminPassword="$(docker exec -it -uroot $JENKINS_NAME bash -c "cat var/jenkins_home/secrets/initialAdminPassword")"
done
echo ${initialAdminPassword} > going_headless/initialAdminPassword.txt
