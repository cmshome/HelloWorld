package com.lxk.sigar;

/**
 * 单个节点信息model
 * <p>
 * @author lxk on 2017/1/5
 */
public class SigarInfoEntity {
    private String value;
    private String name;


    public SigarInfoEntity() { }

    public SigarInfoEntity(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
