#!/usr/bin/env bash
cd /home/ubuntu/mockany
sudo java -jar -Xms128m -Xmx256m -Dserver.port=80 -Dspring.data.mongodb.uri=$MONGODB_URI -Dspring.profiles.active=production \
    build/libs/mock-any-service-*.jar > /dev/null 2> /dev/null < /dev/null &
