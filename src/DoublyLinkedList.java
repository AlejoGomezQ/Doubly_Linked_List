public class DoublyLinkedList {

    static Node head; // head of list

    static class Node {

        int data;
        Node next, prev;

        Node(int d)
        {
            data = d;
            next = prev = null;
        }
    }

    Node split(Node head)
    {
        Node fast = head;
        Node slow = head;

        while (fast.next != null
                && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

    // Function to merge two linked lists
    Node merge(Node first, Node second)
    {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }
        else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    Node mergeSort(Node node)
    {
        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node);

        node = mergeSort(node);
        second = mergeSort(second);

        return merge(node, second);
    }

    void print(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args)
    {

        DoublyLinkedList list = new DoublyLinkedList();
        list.head = new Node(10);
        list.head.next = new Node(30);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(20);
        list.head.next.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next.next = new Node(15);

        Node node = null;
        node = list.mergeSort(head);
        System.out.println("Linked list after sorting :");
        list.print(node);
    }
}