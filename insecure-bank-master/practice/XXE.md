## XXE

### 해결책

- 외부에서 송신된 XML 파일에서 DTD에 대한 원천차단
- 예시에선 Rest API에서 자주 사용되는 Jackson 라이브러리에 대한 수행
- 사용되는 라이브러리에 대한 차단 설정 필요

```java
public class SecureXmlParser {
    
    // Rest Api 환경에서 많이 사용되는 외부 dtd 차단
    // XML ->  java로 직렬/역직렬하거나 파싱하는데 사용
    private static final XmlMapper xmlMapper;

    // xmlMapper에 DTD 차단설정 및 객체 생성
    static {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);

        xmlMapper = new XmlMapper(factory);
    }

    // XML를 Java의 클래스(Generic)로 파싱. xml에 따라 적절한 DTO 정의 필요
    public static <T> T parseXml(InputStream inputStream, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(inputStream, clazz);
    }
}
```