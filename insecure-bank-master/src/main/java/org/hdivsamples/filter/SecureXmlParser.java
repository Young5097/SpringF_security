package org.hdivsamples.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
