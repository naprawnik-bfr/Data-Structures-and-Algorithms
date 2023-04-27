package o1_linkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public Node getHead() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }
    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }
    public int getLength() {
        return length;
    }
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {

        if(length == 0) return null;

        Node temp = head;
        Node pre = head;

        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index -1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();

        Node prev = get(index -1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void merge(LinkedList otherList){
        Node otherHead = otherList.getHead();
        Node dummy = new Node(0);
        Node current = dummy;

        while (head != null && otherHead != null) {
            if (head.value < otherHead.value) {
                current.next = head;
                head = head.next;
            } else {
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            current = current.next;
        }

//        if (head != null) {
//            current.next = head;
//        } else {
//            current.next = otherHead;
//        }

        head = dummy.next;
        length += otherList.getLength();
    }
}

