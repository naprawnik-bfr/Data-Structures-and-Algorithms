package o5_binarySearchTree;

public class BinarySearchTree {

    //after the classes should be private;
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

//    public BinarySearchTree (int value){
//
//        Node newNode = new Node(value);
//        root = newNode;
//
//    } // no need to put it when we create empty binary tree.

    public boolean insert(int value){
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            if(newNode.value == temp.value) return false;
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if(temp.right == null){
                    temp.right =  newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        //-------------------------------------------------------------------------------------------------------
        // is redundant because we can check it during while loop - will be declined in first condition check.
        if (root == null) return false;
        //-------------------------------------------------------------------------------------------------------
        Node temp = root;
        while (temp != null){
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        } return false;
    }

    private boolean rContains(Node currentNode, int value){
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains (int value){
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value){
        if (currentNode == null) return new Node(value);
        if (value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        } else {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert (int value){
        if (root == null) {
            root = new Node(value);
            return;
        }
        rInsert(root, value);
    }

    private Node deleteNode (Node currentNode, int value){
        if (currentNode == null) return null;
        if (value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.left == null){
                return null;
            } else if (currentNode.left == null ){
                currentNode = currentNode.right;
            } else if (currentNode.right == null ){
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public void deleteNode (int value){
        deleteNode(root, value);
    }

    public int minValue (Node currentNode){
         while (currentNode.left != null){
             currentNode = currentNode.left;
         } return currentNode.value;
    }

}
