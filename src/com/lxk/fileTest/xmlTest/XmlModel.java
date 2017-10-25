package com.lxk.fileTest.xmlTest;

import java.util.List;

/**
 * 配置文件节点 model
 * <p>
 * @author lxk on 2016/11/10
 */
public class XmlModel {
    /**
     * 流ID
     */
    private List<String> streamIds;
    /**
     * 流名称
     */
    private String name;


    /**
     * 默认构造函数
     * (在构造model的时候，若要添加新的带参数构造函数，那么这个默认函数一定要写。避免出现你不知道的错)
     */
    public XmlModel() {
    }

    /**
     * 带参构造函数
     */
    public XmlModel(List<String> streamIds, String name) {
        this.streamIds = streamIds;
        this.name = name;
    }

    public List<String> getStreamIds() {
        return streamIds;
    }

    public void setStreamIds(List<String> streamIds) {
        this.streamIds = streamIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "单个节点{" +
                "streamIds=" + streamIds +
                ", name='" + name + '\'' +
                '}';
    }
}
