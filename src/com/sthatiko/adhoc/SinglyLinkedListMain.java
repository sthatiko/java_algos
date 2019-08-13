package com.sthatiko.adhoc;

import java.util.Objects;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.insertAtEnd(5);
        sll.insertAtEnd(4);
        sll.insertAtEnd(3);
        sll.insertAtEnd(2);
        sll.printList();
        reverse(sll);
        sll.printList();
}

    public static <T> void reverse(SinglyLinkedList<T> list){
        if(list.isEmpty() || list.size == 1) return;
        SinglyLinkedList.Node left = list.headNode, middle = left.nextNode, right = middle.nextNode;
        left.nextNode = null;
        while(middle != null){
            middle.nextNode = left;
            left = middle;
            middle = right;
            if(right != null) right=right.nextNode;
        }
        list.headNode = left;
    }
}
