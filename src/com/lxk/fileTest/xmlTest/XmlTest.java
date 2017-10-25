package com.lxk.fileTest.xmlTest;

import com.google.common.collect.Lists;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author lxk on 2016/11/10
 */
public class XmlTest {
    public static void main(String[] args) {
        xmlTest();
    }

    /**
     * 测试解析xml文件
     */
    @SuppressWarnings("unchecked")
    private static void xmlTest() {
        SAXReader reader = new SAXReader();
        reader.setEncoding("utf-8");
        Document document;
        try {
            document = reader.read(new File("src/testConfig.xml"));
            Element root = document.getRootElement();//得到xml跟标签，此处是<root></root>
            List<Element> list = root.elements("stream");
            List<XmlModel> xmlNodeList = Lists.newArrayList();//得到xml文件的配置信息
            for (Element e : list) {
                List<String> streamIds = Arrays.asList(e.element("streamId").getStringValue().split(","));
                XmlModel temp = new XmlModel(streamIds, e.element("name").getStringValue());
                xmlNodeList.add(temp);
            }
            for (XmlModel xmlModel : xmlNodeList) {
                System.out.println(xmlModel);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
