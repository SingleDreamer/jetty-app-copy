#!/usr/bin/env bash
source config.sh

./sonarqube.sh

./jenkins.sh

./gitlab.sh

GITLAB_PRIVATE_ACCESS_TOKEN="$(curl http://192.168.99.100:30080/api/v4/session --data 'login=root&password=*HnYnKkn4869' | jq -r .private_token)"
GITLAB_PERSONAL_ACCESS_TOKEN="$(curl --request POST --header "PRIVATE-TOKEN: $GITLAB_PRIVATE_ACCESS_TOKEN" --data "name=mytoken" --data "scopes[]=api" http://192.168.99.100:30080/api/v4/users/1/impersonation_t
okens | jq -r .token)"

cd going_headless

python add_credentials.py

#python going_headless/get_jenkins_password.py

#GITLAB_PRIVATE_ACCESS_TOKEN="$(curl http://192.168.99.100:30080/api/v4/session --data 'login=root&password=*HnYnKkn4869' | jq '.private_token' curl http://192.168.99.100:30080/api/v4/session --data 'login=root&password=*HnYnKkn4869' | jq '.private_token')"
#echo GITLAB_PRIVATE_ACCESS_TOKEN
#GITLAB_PERSONAL_ACCESS_TOKEN="$(curl --request POST --header "PRIVATE-TOKEN: TqffaQpkuMcxiixSfADs" --data "name=mytoken" --data "expires_at=2018-08-07" --data "scopes[]=api" http://192.168.99.100:30080 /api/v4/users/1/impersonation_tokens | jq '.token')"
#echo GITLAB_PERSONAL_ACCESS_TOKEN

#python going_headless/add_credentials.py
#python going_headless/configure.py

# local docker registry
docker run -d -p 5000:5000 --restart=always --name $REGISTRY_NAME registry:2
