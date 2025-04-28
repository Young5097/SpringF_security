<h3>환경설정</h3>

<h4>환경변수 설정</h4>

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
3. ID : john / PW : test
