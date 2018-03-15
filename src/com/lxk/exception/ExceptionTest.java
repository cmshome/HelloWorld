package com.lxk.exception;

import com.lxk.model.Test;
import com.lxk.programQuestions.Questions;

/**
 * @author lxk on 2018/3/15
 */
public class ExceptionTest {
    public static void main(String[] args) {
        stackOverflowError();
        outOfMemoryError();
    }

    /**
     * 【堆】内存溢出
     */
    private static void outOfMemoryError() {
        new Test();
    }

    /**
     * 【栈】递归函数炸掉啦
     */
    private static void stackOverflowError() {
        long result = Questions.questions7(100000);
        System.out.println(result);
    }


}
