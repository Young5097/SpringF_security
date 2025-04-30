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

1.  SRC/exec/sonarqube9_start.bat 실행
2. [localhost:9000](http://localhost:9000) → ID : admin/PW : admin
3. 개발환경에 맞게 선택 ->  토큰발급/빌드툴 선택
   
   ![sonar1](https://github.com/user-attachments/assets/9e631565-8770-423c-972d-d4e2323cc298)
   
   ![sonar2](https://github.com/user-attachments/assets/bfafa5db-789e-4a5a-9e85-a0fb9ec648dc)

3-1. cmd에서 실행안되는 경우 
  - 한줄로 처리 -> '-Dsonar' 옵션을 리터럴 처리 ("" or ''으로 감싸기)
  - ```
    mvn clean verify sonar:sonar "-Dsonar.projectKey=AA" "-Dsonar.host.url=http://localhost:9000" "-Dsonar.login=sqp_ac04bca92276584097b7923ab2c2ad07e612adcb"
    ```
4. 정상적으로 빌드가 되면 아래 화면출력
  ![image](https://github.com/user-attachments/assets/d9347337-3651-4c03-9029-1e1ed0e4b93d)
