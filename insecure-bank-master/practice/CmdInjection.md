## CmdInjection

### 해결책

- 화이트 리스트 클래스를 생성해, 명령에 대한 검증 수행

```java
    public class AllowedCommands {

        private static final List<String> allowed = Arrays.asList("date", "to account");

        public static boolean isAllowed(String inputCommand) {
            return allowed.contains(inputCommand);
        }
    }
```