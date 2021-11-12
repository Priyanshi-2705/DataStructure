/*   Created by IntelliJ IDEA.
 *   Author: Priyanshi Jaiswal
 *   Date: 04-10-2021
 *   Time: 15:31
 *   File: SinglyLinkedList.java
 */

package singlyLinkedList;
public class SinglyLinkedList {
    private ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length() {
        if(head == null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
       if(head == null){
           head = newNode;
           return;
       }
       ListNode current = head;
       while(current.next != null){
           current = current.next;
       }
       current.next = newNode;
    }

    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast(){
        if(head == null || head.next == null){
            head = null;
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    //Insert a node at a given position by the user

    public void insert(int position, int value){
        ListNode node = new ListNode(value);
        if(position == 1){
            node.next = head;
            head = node;
        }
        else{
            ListNode previous = head;
            int count = 1;
            while (count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    //Delete a node of a given position by the user
    public void delete(int position){
        if(position == 1){
            head = head.next;
        }
        else{
            ListNode previous = head;
            int count = 1;
            while (count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public ListNode getMiddleNode() {
        if (head == null) {
            return null;
        }
        else {
            ListNode slowPtr = head;
            ListNode fastPtr = head;
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            return slowPtr;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);
//        sll.head.next = second;                  //10 --> 1
//        second.next = third;                     //10 --> 1 --> 8
//        third.next = fourth;                     // 10 --> 1 --> 8 --> 11 --> null
//        sll.insertLast(11);
//        sll.insertLast(8);
//        sll.insertLast(1);
//        sll.insertLast(10);
//        sll.display();
//        System.out.println(sll.deleteLast().data);
//        System.out.println(sll.deleteLast().data);
        sll.insert(1,3);
        sll.insert(2,5);
        sll.insert(1,2);
        sll.insert(2,4);
        sll.display();
        //System.out.println(sll.getMiddleNode());
        sll.delete(4);
        sll.display();
        sll.delete(3);
        sll.display();
//        sll.delete(3);
//        sll.display();
//        System.out.print("Length is :- " + sll.length());
    }
}
