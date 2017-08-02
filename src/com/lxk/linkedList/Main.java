package com.lxk.linkedList;

import com.lxk.linkedList.oneWay.Node;

import static com.lxk.linkedList.circularList.CircularOneWayList.getCircularOneWayList;
import static com.lxk.linkedList.oneWay.OneWayLinkedList.*;

/**
 * 链表测试
 * <p>
 * Created by lxk on 2017/8/1
 */
public class Main {
    public static void main(String[] args) {
        testOneWayLinkedList();//单向链表
        testCircularOneWayList();//循环链表
    }

    /**
     * 测试循环链表
     */
    private static void testCircularOneWayList() {
        Node<Integer, Integer> linkedList = getCircularOneWayList();//获得初始化链表
        //forLinkedList(linkedList);//打印
    }

    /**
     * 测试单向链表
     */
    private static void testOneWayLinkedList() {
        Node<Integer, Integer> linkedList = getOneWayLinkedList();//获得初始化链表---头插法
        //Node<Integer, Integer> linkedList = getOneWayLinkedListTail();//获得初始化链表---尾插法
        int size = getOneWayLinkedListSize(linkedList);
        System.out.println("oneWayLinkedList's size：" + size);//链表长度
        forLinkedList(linkedList);//打印
        insertInLinkedList(5, 10, 10, linkedList);//在下标为5的节点之后插入
        forLinkedList(linkedList);//打印
        removeInLinkedList(5, linkedList);//在下标为5的节点之后删除
        forLinkedList(linkedList);//打印
    }


}
