package com.lxk.linkedList;

import com.lxk.linkedList.oneWay.Node;

import static com.lxk.linkedList.circularList.CircularOneWayList.*;
import static com.lxk.linkedList.oneWay.OneWayLinkedList.*;

/**
 * 链表测试
 * <p>
 * @author lxk on 2017/8/1
 */
public class Main {
    public static void main(String[] args) {
        testOneWayLinkedList();//单向链表
        //testCircularOneWayList();//循环链表
    }

    /**
     * 测试循环链表
     */
    private static void testCircularOneWayList() {
        Node<Integer, Integer> linkedList = getCircularOneWayList();//获得初始化链表
        //forLinkedList(linkedList);//打印
        System.out.println(getCircularLinkedListSize(linkedList));
    }

    /**
     * 测试单向链表
     */
    private static void testOneWayLinkedList() {
        ////获得初始化链表---头插法
        //Node<Integer, Integer> linkedList = getOneWayLinkedList(6);
        ////获得初始化链表---尾插法
        ////Node<Integer, Integer> linkedList = getOneWayLinkedListTail();
        //int size = getOneWayLinkedListSize(linkedList);
        ////链表长度
        //System.out.println("oneWayLinkedList's size：" + size);
        ////打印
        //forLinkedList(linkedList);
        ////在下标为5的节点之后插入
        //insertInLinkedList(5, 10, 10, linkedList);
        ////打印
        //forLinkedList(linkedList);
        ////在下标为5的节点之后删除
        //removeInLinkedList(5, linkedList);
        ////打印
        //forLinkedList(linkedList);

        Node<Integer, Integer> linkedList = getOneWayLinkedList(6);
        forLinkedList(linkedList);
        Node<Integer, Integer> node = reverseLinkedList(linkedList);
        forLinkedList(node);
    }



}
