
class Node {
    int data;
    Node prev;
    Node next;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        prev = null;
        next = null;
        left = null;
        right = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null)
            return false;

        if (root.data == data)
            return true;

        if (data < root.data)
            return searchRec(root.left, data);

        return searchRec(root.right, data);
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        BinaryTree binaryTree = new BinaryTree();

      
        for (int i = 0; i < 10000; i++) {
            int value = (int) (Math.random() * 10000);
            doublyLinkedList.insert(value);
            binaryTree.insert(value);
        }


        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int value = (int) (Math.random() * 10000);
            doublyLinkedList.search(value);
        }
        long doublyLinkedListTime = System.nanoTime() - startTime;


        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int value = (int) (Math.random() * 10000);
            binaryTree.search(value);
        }
        long binaryTreeTime = System.nanoTime() - startTime;

        System.out.println("Tiempo de búsqueda en lista doblemente enlazada: " + doublyLinkedListTime + " nanosegundos");
        System.out.println("Tiempo de búsqueda en árbol binario: " + binaryTreeTime + " nanosegundos");
    }
}


