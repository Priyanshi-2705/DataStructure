/*   Created by IntelliJ IDEA.
 *   Author: Priyanshi Jaiswal
 *   Date: 10-11-2021
 *   Time: 13:06
 *   File: Main.java
 */

package doublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return  length == 0;
    }

    //Insert value at First in DLL

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        }
        else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    //Insert value at the end/last in DLL

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    //Print element of DLL

    //For Forward Display

    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + "---> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //For Backward Display

    public void displayBackward(){
        if(head == null){
            return;
        }
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + "---> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    //Delete the node of DLL

    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if(head == tail){
            tail = null;
        }
        else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(3);

        dll.displayForward();
        dll.displayBackward();

    }
}
