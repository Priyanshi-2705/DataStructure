/*   Created by IntelliJ IDEA.
 *   Author: Priyanshi Jaiswal
 *   Date: 10-11-2021
 *   Time: 15:24
 *   File: CircularLinkedList.java
 */

package circularLinkedList;

public class CircularLinkedList {
    private ListNode last;
    private  int length;

    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularLinkedList(){
        last = null;
        length = 0;
    }

    public  int length(){
        return  length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    //Traverse and print a CLL
    public void display(){
        if(last == null) {
            return;
        }
        ListNode first = last.next;
        while(first != last){
            System.out.println(first.data + "---> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    //Insert at the beginning
    public void insertFirst(int data){
        ListNode temp = new ListNode(data);
        if(last == null){
            last = temp;
        }
        else{
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void createCircularLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
    }
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();
        cll.display();
    }
}
