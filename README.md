# TGS 프로젝트 Backend

### :gear: 프로젝트 환경 설정

#### :pencil2: 사전 준비 사항

- <a href="https://www.oracle.com/kr/java/technologies/javase/jdk11-archive-downloads.html">Java 11</a> 버전 다운로드 및 <a href="https://blog.naver.com/PostView.naver?blogId=cmh348&logNo=222110413109">환경 변수 세팅</a>



#### :computer: 프로젝트 실행 방법

1. 프로젝트 Clone 받기

```bash
$ git clone https://github.com/The-Greatest-Study/tgs_backend.git
```



2. 프로젝트 Root 폴더에서 Gradle Wrapper로 Spring Boot 프로젝트 실행 *(./gradlew 명령어가 동작하지 않을 경우, git bash 터미널에서 실행해주세요)*

```bash
$ ./gradlew bootRun
```



3. http://localhost:8080 으로 접속했을 시, 아래와 같은 화면이 뜨면 접속 성공!

![열씨미 공부하는 고앵이](assets/main.png)

#### :chart_with_upwards_trend: API 사용 방법

별도의 개발 환경 설정 없이, 배포된 API만 사용하기를 원한다면, 아래 url로 접속하여 사용하시면 됩니다.

```
https://the-greatest-study.herokuapp.com/<상세경로>
```

:white_check_mark: 상세 API 리스트: <a href="https://www.notion.so/API-9ac22ff286c14c16a2093438c951a870">바로가기</a>
