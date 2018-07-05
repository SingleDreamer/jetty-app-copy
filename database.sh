#!/usr/bin/env bash
docker run --name jettyapp-mysql \
        -p 3306:3306 \
        -e MYSQL_DATABASE=task \
	-e MYSQL_ROOT_PASSWORD=supersecretpassword \
	-e MYSQL_USER=myuser \
        -e MYSQL_PASSWORD=mysecretpassword \
        -d mysql 
