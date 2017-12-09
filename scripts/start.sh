#!/usr/bin/env bash
echo "primeira parte" > primeiro.txt
cd /home/ubuntu/mockany
echo "segundo step " > segundo.txt
sudo java -jar -Xms128m -Xmx256m -Dserver.port=80 -Dspring.data.mongodb.uri=$MONGODB_URI -Dspring.profiles.active=production \
    build/libs/mock-any-service-*.jar > /dev/null 2> /dev/null < /dev/null &
echo "terceiro step " > terceiro.txt
