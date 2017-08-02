package com.lxk.linkedList.oneWay;

/**
 * 单向链表
 * <p>
 * Created by lxk on 2017/8/1
 */
public class OneWayLinkedList {

    /**
     * 获得单向链表（头插法生成的单向链表--后来的在链表头部）
     */
    public static Node<Integer, Integer> getOneWayLinkedList() {
        Node<Integer, Integer> temp = null;
        for (int i = 1; i <= 6; i++) {
            temp = new Node<>(i, i, temp);//头插法：先来的在链尾
        }
        return temp;
    }

    /**
     * 获得单向链表（尾插法生成的单向链表--后来的链在链表尾部）
     */
    public static Node<Integer, Integer> getOneWayLinkedListTail() {
        Node<Integer, Integer> headWillMove = new Node<>(1, 1, null);
        Node<Integer, Integer> headNoMove = headWillMove;//headWillMove，但是这个headNoMove是一直指向链表头的。返回他就对了。
        for (int i = 2; i <= 6; i++) {
            headWillMove.setNext(new Node<>(i, i, null));//尾插法：先来的在链头
            headWillMove = headWillMove.getNext();
        }
        return headNoMove;
    }

    /**
     * 输出单向链表
     */
    public static void forLinkedList(Node<Integer, Integer> linkedList) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (linkedList != null) {
            sb.append("[k：").append(linkedList.getKey()).append(" v：").append(linkedList.getValue()).append("]");
            linkedList = linkedList.getNext();
        }
        sb.append("}");
        System.out.println(sb.toString());
    }

    /**
     * 获得单向链表的最后一个节点
     */
    public static Node<Integer, Integer> getLastNode(Node<Integer, Integer> linkedList) {
        while (linkedList.getNext() != null) {
            linkedList = linkedList.getNext();
        }
        return linkedList;
    }

    /**
     * 获得链表的长度
     */
    public static int getOneWayLinkedListSize(Node<Integer, Integer> linkedList) {
        int size = 0;
        while (linkedList != null) {
            size++;
            linkedList = linkedList.getNext();
        }
        return size;
    }

    /**
     * 在链表指定位置之后插入元素
     */
    public static void insertInLinkedList(int index, int key, int value, Node<Integer, Integer> linkedList) {
        int size = getOneWayLinkedListSize(linkedList);
        if (index < 0 || index >= size) {
            System.out.println("out of index bounds");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (index == i) {
                linkedList.setNext(new Node<>(key, value, linkedList.getNext()));
                break;
            }
            linkedList = linkedList.getNext();
        }
    }

    /**
     * 在链表指定位置之后删除节点
     */
    public static void removeInLinkedList(int index, Node<Integer, Integer> linkedList) {
        int size = getOneWayLinkedListSize(linkedList);
        if (index < 0 || index >= size) {
            System.out.println("out of index bounds");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (index == i) {
                if (linkedList.getNext() == null) {
                    System.out.println("out of index bounds");
                    break;
                }
                linkedList.setNext(linkedList.getNext().getNext());
                break;
            }
            linkedList = linkedList.getNext();
        }
    }

}