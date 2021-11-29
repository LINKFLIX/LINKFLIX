#!/bin/bash

if [ -f /home/ubuntu/deploy.log ]; then
    rm /home/ubuntu/deploy.log
fi
touch /home/ubuntu/deploy.log

echo "Start Deploy..." >> /home/ubuntu/deploy.log
date >> /home/ubuntu/deploy.log
pwd >> /home/ubuntu/deploy.log

echo "Execute backend" >> /home/ubuntu/deploy.log
cd /home/ubuntu/LINKFLIX-deploy/backend
chmod +x dockerbuild.sh
pwd >> /home/ubuntu/deploy.log
./dockerbuild.sh >> /home/ubuntu/deploy.log 2>> /home/ubuntu/deploy.log < /dev/null &

echo "Execute crawl" >> /home/ubuntu/deploy.log
cd /home/ubuntu/LINKFLIX-deploy/crawl
chmod +x dockerbuild.sh
pwd >> /home/ubuntu/deploy.log
./dockerbuild.sh >> /home/ubuntu/deploy.log 2>> /home/ubuntu/deploy.log < /dev/null &
