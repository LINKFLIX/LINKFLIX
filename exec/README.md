# 1. 배포 과정

docker, jenkins, nginx를 통해 백엔드, 프론트엔드를 빌드하고 배포합니다.

특정 브런치에 push 작업이 발생할 때마다 빌드 및 배포를 자동화 시켰습니다.

1. EC2 ssh 접속(`ubuntu@k5a104.p.ssafy.io`)

2. docker 설치

3. jenkins, mysql 도커 이미지 다운로드 및 컨테이너화

   jenkins는 8000번 포트, mysql은 3306번 포트를 연결시킵니다.

   mysql에서 테이블(table)은 JPA를 통해 생성되지만, 스키마(schema)는 직접 생성해주어야 합니다. mysql 컨테이너에 접속하여 스키마를 생성합니다.

4. jenkins CI/CD 파이프라인 구축

   jenkins가 정상적으로 구동되고 있다면 `k5a104.p.ssafy.io:8000`으로 접속할 수 있습니다. 여기서 CI/CD 파이프라인을 구축합니다.

   백엔드와 프론트엔드의 빌드 및 배포를 스크립트로 구현합니다.

   **jenkins 쉘 스크립트**

   ```shell
   cd backend
   chmod 777 gradlew
   ./gradlew clean build
   chmod 777 dockerbuild.sh
   sh dockerbuild.sh
   cd ../crawl
   chmod 777 dockerbuild.sh
   sh dockerbuild.sh
   cd ../landingpage
   npm install
   npm run build
  ```

   - GitHub에 대한 hook 설정과 Node 설치가 필요합니다.

   - `dockerbuild.sh` : 백엔드를 컨테이너화하고, 이전에 실행중이던 컨테이너를 삭제하고 새로 실행시킵니다.

   - `Dockerfile` : `dockerbuild.sh`에서 `docker build` 명령어에 필요한 설정파일입니다. 백엔드를 도커라이징 하면서 JDK, 포트, 볼륨을 설정합니다.

 nginx 및 https 설정

   jenkins를 통해 빌드된 프론트엔드의 `index.html`을 nginx에 연결합니다.

   **/etc/nginx/nginx.conf**

   ```shell
     server {
        listen      80;
        server_name k5a104.p.ssafy.io;

        return 301 https://$host$request_uri;
    }


      server {
        listen  443 ssl;
        server_name  k5a104.p.ssafy.io;

        ssl_certificate     /etc/letsencrypt/live/k5a104.p.ssafy.io/fullchain.pem;
        ssl_certificate_key  /etc/letsencrypt/live/k5a104.p.ssafy.io/privkey.pem;
        ssl_session_cache    shared:SSL:1m;
        ssl_session_timeout  5m;

        location / {
             root /var/jenkins/workspace/LINKFLIX/landingpage/dist;
             index index.html;
             try_files $uri /index.html;
        }
    }
   ```

## 개발 환경

- JVM : openjdk-8
- IDE : IntelliJ IDEA Ultimate 2021.2, Visual Studio Code 1.60.2
- Server : nginx 1.18.0, Spring boot 2.5.5(Tomcat)

# 2. 외부 서비스 정보

없음.

# 3. 데이터베이스 덤프

[linkflix_products.sql](./linkflix_products.sql)  
[linkflix_timelines.sql](./linkflix_timelines.sql)

# 4. 시연 시나리오

1. 랜딩페이지에 접속하여 크롬 익스텐션 LINKFLIX를 설치합니다.
2. 넷플릭스 홈페이지에 접속 후, 이용 가능한 콘텐츠를 선택합니다.
3. 하단에 장바구니 버튼을 누른 후, 사이드바를 통하여 해당 회차의 상품 정보들을 확인합니다.
4. 원하는 상품을 클릭 후, 쇼핑몰로 이동합니다.

