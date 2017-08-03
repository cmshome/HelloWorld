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
     *
     * @return 获得单向循环链表，默认返回的就链表头。
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

    /**
     * 获得循环链表的长度(要想获得长度，得设置个停止标记。)
     *
     * @param linkedList 单向循环链表，(必须是)链表头的位置开始。
     */
    public static int getCircularLinkedListSize(Node<Integer, Integer> linkedList) {
        //注意：前提条件-->假设所有的值不重复，才能这么干。
        int size = 1;//默认从1开始，循环到1时结束，
        linkedList = linkedList.getNext();//跨过key为1的节点，也就是把key为1的节点，作为标记。
        while (linkedList.getKey() != 1) {
            size++;
            linkedList = linkedList.getNext();
        }
        return size;
    }

}
