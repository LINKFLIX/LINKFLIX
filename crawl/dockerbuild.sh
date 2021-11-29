cd /home/ubuntu/LINKFLIX-deploy/crawl

docker container stop flask
docker container rm flask
docker build -t flask .

docker run --name flask -d -p 5000:5000 flask

docker rmi $(docker images -f "dangling=true" -q)