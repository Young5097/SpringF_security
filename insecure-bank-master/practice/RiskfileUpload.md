## RiskfileUpload

### 해결책

- 적절한 파일 형식인지 체크하는 필터 추가
- 해당 경우는 이미지를 넣을 수 없는 곳에 이미지가 업로드 되는 것을 방지

```java
public class FileNameFilter {
    
    public static boolean chkFileName(String fileName) {
        if (fileName != null) {
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            if (!"gif".equals(fileExt) && !"png".equals(fileExt) && !"jpg".equals(fileExt)) {
                String message = "업로드 불가능한 파일";
                return false;
            }
        }

        return true;
    }
}
```