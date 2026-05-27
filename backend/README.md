# project_todo_list_back

Spring Boot 기반의 Todo List 백엔드 프로젝트입니다.  
사용자 인증과 날짜별 Todo 데이터 관리를 위한 REST API를 제공합니다.

## 주요 기능
- 회원가입
- 로그인
- Todo 등록
- Todo 조회
- Todo 수정
- Todo 삭제
- Todo 완료 여부 변경

## API
### Auth
- `POST /auth/signup`
- `POST /auth/login`

### Todo
- `GET /todos`
- `POST /todos`
- `PUT /todos/{todoId}`
- `DELETE /todos/{todoId}`

## Tech Stack
- Java
- Spring Boot
- Spring Web
- MySQL
- Maven

## 실행 방법
```bash
./mvnw spring-boot:run