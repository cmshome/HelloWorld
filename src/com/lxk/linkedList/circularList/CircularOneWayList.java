package com.lxk.linkedList.circularList;

import com.lxk.linkedList.oneWay.Node;
import com.lxk.linkedList.oneWay.OneWayLinkedList;

/**
 * 循环链表
 * <p>
 * Created by lxk on 2017/8/1
 */
public class CircularOneWayList {

    /**
     * 获得单向循环链表
     */
    public static Node<Integer, Integer> getCircularOneWayList() {
        //获得的单向链表的头
        Node<Integer, Integer> head = OneWayLinkedList.getOneWayLinkedListTail();
        //找到这个链表的尾
        Node<Integer, Integer> tail = OneWayLinkedList.getLastNode(head);
        //首尾相连，就成环了。
        tail.setNext(head);
        return head;
    }

}
