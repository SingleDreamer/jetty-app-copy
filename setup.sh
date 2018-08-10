#!/usr/bin/env bash
source config.sh

./sonarqube.sh

./jenkins.sh

./gitlab.sh

GITLAB_PRIVATE_ACCESS_TOKEN="$(curl http://192.168.99.100:30080/api/v4/session --data 'login=root&password=GitPass1!' | jq -r .private_token)"
#GITLAB_PERSONAL_ACCESS_TOKEN="$(curl --request POST --header "PRIVATE-TOKEN: $GITLAB_PRIVATE_ACCESS_TOKEN" --data "name=mytoken" --data "scopes[]=api" http://192.168.99.100:30080/api/v4/users/1/impersonation_tokens | jq -r .token)"
python get_personal_gitlab_api.py > gitlab_PAT.txt
GITLAB_PERSONAL_ACCESS_TOKEN="$(cat gitlab_PAT.txt)"

cd going_headless

echo "adding credeintials"

python add_credentials.py root GitPass1! GITLAB_PERSONAL_ACCESS_TOKEN


# import project
PROJECT_ID="$(curl --request POST -H "Content-Type: application/json" --header "PRIVATE-TOKEN: $GITLAB_PRIVATE_ACCESS_TOKEN"  --data '{"user_id":"1", "name":"jetty-app", "import_url":" https://github.com/SingleDreamer/jetty-app-copy.git"}' http://192.168.99.100:30080/api/v4/projects | jq -r .id)"


python create_jenkins_job.py

#create gitlab ebhook
curl -H "PRIVATE-TOKEN: $GITLAB_PRIVATE_ACCESS_TOKEN" -H "Content-Type:application/json" --data '{"id":"$PROJECT_ID","url":"http://192.168.99.100:8080/project/jetty-gitlab-test","enable_ssl_verification":false, "push_events":true}' http://192.168.99.100:30080/api/v4/projects/$PROJECT_ID/hooks

#python going_headless/get_jenkins_password.py

#python going_headless/add_credentials.py
#python going_headless/configure.py

# local docker registry
docker run -d -p 5000:5000 --restart=always --name $REGISTRY_NAME registry:2
