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
        SinglyLinkedList<T>.Node prev = null; //To keep track of the previous element, will be used in swapping links
        SinglyLinkedList<T>.Node current = list.headNode; //firstElement
        SinglyLinkedList<T>.Node next = null;
        //While Traversing the list, swap links
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        //Linking Head Node with the new First Element
        list.headNode = prev;
    }
}
