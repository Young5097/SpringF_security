<h3>환경설정</h3>

1. 아래 파일들 설치

![Config](https://github.com/user-attachments/assets/249f55d2-c062-409d-a795-99c5aca2d995)

2. 환경변수 설정
```
setx JAVA_HOME "C:\Program Files\Java\jdk-17" /M<br/>
setx PATH "%PATH%;%JAVA_HOME%\bin" /M

setx MAVEN_HOME "C:\Program Files\Apache\Maven\apache-maven-3.9.6" /M<br/>
setx PATH "%PATH%;%MAVEN_HOME%\bin" /M
```

<h4>실행</h4>

1. 프로젝트 경로에서 웹 어플리케이션 실행
```
mvn cargo:run
```

2. <strong>http://localhost:8080/insecure-bank</strong>
3. 로그인 -> <strong>ID : john / PW : test</strong>

<hr/>

<h3>SonarQube 실행</h4>

- SRC/exec/sonarqube9_start.bat 실행

