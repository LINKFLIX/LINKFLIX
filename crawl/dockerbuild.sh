docker build -t flask-image ./
docker run --name flask-container -d -p 5000:5000 flask-image