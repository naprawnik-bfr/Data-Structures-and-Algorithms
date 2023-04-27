package o5_binarySearchTree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.rInsert(2);
        myBST.rInsert(1);
        myBST.rInsert(3);

        System.out.println("\nRoot: " + myBST.root.value);
        System.out.println("Root -> Left: " + myBST.root.left.value);
        System.out.println("Root -> Right: " + myBST.root.right.value);

        myBST.deleteNode(2);

        System.out.println("\nRoot: " + myBST.root.value);
        System.out.println("Root -> Left: " + myBST.root.left.value);
        System.out.println("Root -> Right: " + myBST.root.right);

    }
}
