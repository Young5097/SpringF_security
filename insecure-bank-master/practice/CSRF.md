## XXE

### 해결책

#### csrf 활성화
- csrf 토큰
- Spring Security가 알아서 생성함.
#### csrf 비활성화
- JWT 토큰 활용

```html
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
```