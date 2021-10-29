docker build -t flask-image ./
docker run --name flask-container -ad -p 5000:5000 flask-image