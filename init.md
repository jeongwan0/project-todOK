# Codespaces에서 실행할 명령어


## 터미널 1 — MySQL

docker start todok-mysql


## 터미널 2 — 백엔드

read -rsp "MySQL 비밀번호: " DB_PASS
echo
export SPRING_DATASOURCE_PASSWORD="$DB_PASS"
cd /workspaces/project-todOK/backend
bash ./mvnw spring-boot:run

처음 컨테이너를 만들 때 정한 MySQL 비밀번호를 입력하세요. Started TodoApplication이 뜨면 터미널을 켜 둡니다.


## 터미널 3 — 프론트

cd /workspaces/project-todOK/frontend
npm run dev -- --host 0.0.0.0

VITE ready가 뜨면 Codespaces의 5173 포트 주소로 접속하세요.


## 코드 수정 후 GitHub에 저장

cd /workspaces/project-todOK
git status --short
git add .
git commit -m "Update todOK"
git push origin main