package com.lxk.interfaceTest;

/**
 * @author LiXuekai on 2019/8/30
 */
public class Implement extends Abstract {
    @Override
    public void loadSyncStream(CallBack callBack) {
        callBack.callBack("xxx");
    }
}
