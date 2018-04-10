package com.lxk.linkedList.oneWay;

/**
 * 单向链表
 * <p>
 * @author lxk on 2017/8/1
 */
public class OneWayLinkedList {

    /**
     * 获得单向链表（头插法生成的单向链表--后来的在链表头部）
     */
    public static Node<Integer, Integer> getOneWayLinkedList(int length) {
        Node<Integer, Integer> temp = null;
        for (int i = 1; i <= length; i++) {
            //头插法：先来的在链尾
            temp = new Node<>(i, i, temp);
        }
        return temp;
    }

    /**
     * 获得单向链表（尾插法生成的单向链表--后来的链在链表尾部）
     */
    public static Node<Integer, Integer> getOneWayLinkedListTail() {
        Node<Integer, Integer> headWillMove = new Node<>(1, 1, null);
        //headWillMove，但是这个headNoMove是一直指向链表头的。返回他就对了。
        Node<Integer, Integer> headNoMove = headWillMove;
        for (int i = 2; i <= 6; i++) {
            //尾插法：先来的在链头
            headWillMove.setNext(new Node<>(i, i, null));
            headWillMove = headWillMove.getNext();
        }
        return headNoMove;
    }

    /**
     * 输出单向链表
     *
     * @param linkedList 单向链表，链表头的位置开始。
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
     *
     * @param linkedList 单向链表，链表头的位置开始。
     */
    public static Node<Integer, Integer> getLastNode(Node<Integer, Integer> linkedList) {
        while (linkedList.getNext() != null) {
            linkedList = linkedList.getNext();
        }
        return linkedList;
    }

    /**
     * 获得链表的长度
     *
     * @param linkedList 单向链表，链表头的位置开始。
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
     *
     * @param index      指定位置之后插入元素
     * @param key        插入元素的key
     * @param value      插入元素的value
     * @param linkedList 单向链表，链表头的位置开始。
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
     *
     * @param index      指定位置之后删除元素
     * @param linkedList 单向链表，链表头的位置开始。
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

    /**
     * 逆序单链表
     *
     * @param linkedList 单链表
     */
    public static Node<Integer, Integer> reverseLinkedList(Node<Integer, Integer> linkedList) {
        Node<Integer, Integer> reverse = null;
        Node<Integer, Integer> current = linkedList;
        while (current != null) {
            Node<Integer, Integer> temp = current;
            current = current.getNext();
            temp.setNext(reverse);
            reverse = temp;
        }
        return reverse;
    }

}
