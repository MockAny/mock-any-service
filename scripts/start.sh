#!/usr/bin/env bash
cd /home/ubuntu/mockany
sudo java -jar -Dserver.port=80 -Dspring.profiles.active=production \
    *.jar > /dev/null 2> /dev/null < /dev/null &