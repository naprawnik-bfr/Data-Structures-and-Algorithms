package o1_linkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);

        l1.removeFirst();

        l1.printList();

    }
}
