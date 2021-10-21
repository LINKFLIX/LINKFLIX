docker build -t linkflix ./
docker ps -f name=linkflix  -q | xargs --no-run-if-empty docker container stop
docker container ls -a -f name=linkflix -q | xargs -r docker container rm
docker run -d -p 8080:8080 -v /home/ubuntu/upload-images:/upload-images --name linkflix linkflix