cd /home/ubuntu/LINKFLIX-deploy/backend

docker container stop linkflix
docker container rm linkflix
docker build -t linkflix .

docker run -d -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -v /home/ubuntu/product_images:/product_images \
  -v /home/ubuntu/secret:/secret \
  --name linkflix linkflix

docker rmi $(docker images -f "dangling=true" -q)
