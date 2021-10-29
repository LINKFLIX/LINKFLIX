FROM python:3.9

# set a directory for the app
WORKDIR /app

# copy all the files to the container
COPY . .

# 필요한 의존성 file 설치
RUN pip install -r requirements.txt

# tell the port number the container should expose
EXPOSE 5000

# container가 구동되면 실행
ENTRYPOINT ["python", "app.py"]