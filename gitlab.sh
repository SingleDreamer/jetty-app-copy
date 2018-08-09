#!/usr/bin/env bash
source config.sh

# gitlab
    #-e GITLAB_ROOT_PASSWORD=GitPass1 \
docker run --detach \
    --hostname gitlab.example.com \
    --publish 443:443 --publish 30080:80 --publish 30022:22 \
    --name $GITLAB_NAME \
    --restart always \
    --volume gitlab-test-config:/etc/gitlab \
    --volume gitlab-test-logs:/var/log/gitlab \
    --volume gitlab-test-data:/var/opt/gitlab \
    gitlab/gitlab-ce:9.1.0-ce.0
    #gitlab/gitlab-ce:latest
    #--volume /srv/gitlab/config:/etc/gitlab \
    #--volume /srv/gitlab/logs:/var/log/gitlab \
    #--volume /srv/gitlab/data:/var/opt/gitlab \
    #gitlab/gitlab-ce:latest
    #gitlab/gitlab-ce:9.1.0-ce.0

cd going_headless

python configure_gitlab.py
