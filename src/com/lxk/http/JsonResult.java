package com.lxk.http;

import com.lxk.util.JsonUtils;

import java.io.Serializable;

/**
 * 通用 web json 对象规范
 *
 * @author User
 */
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功状态
     */
    private boolean success = false;

    /**
     * 文本信息
     */
    private String msg = "";

    /**
     * 数据
     */
    private Object obj = null;

    public JsonResult() {
    }

    public JsonResult(Object obj) {
        this.success = true;
        this.obj = obj;
    }

    public JsonResult(boolean success) {
        this(success, null);
    }

    public JsonResult(boolean success, String msg) {
        this(success, msg, null);
    }

    public JsonResult(boolean success, String msg, Object obj) {
        this.setSuccess(success);
        this.setMsg(msg);
        this.setObj(obj);
    }

    public JsonResult(ClientException clientException) {
        this.msg = clientException.getMessage();
        this.success = false;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return JsonUtils.parseObjToJson(this);
    }
}
