class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    DoublyLinkedList[] split() {
        DoublyLinkedList[] result = new DoublyLinkedList[2];
        result[0] = new DoublyLinkedList();
        result[1] = new DoublyLinkedList();

        if (head == null || head.next == null) {
            result[0].head = head;
            return result;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        result[0].head = head;
        result[1].head = slow.next;
        slow.next.prev = null;
        slow.next = null;

        return result;
    }

    static DoublyLinkedList merge(DoublyLinkedList l1, DoublyLinkedList l2) {
        DoublyLinkedList mergedList = new DoublyLinkedList();
        Node current1 = l1.head;
        Node current2 = l2.head;

        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.insert(current1.data);
                current1 = current1.next;
            } else {
                mergedList.insert(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.insert(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.insert(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    static void mergesort(DoublyLinkedList l) {
        if (l.head == null || l.head.next == null) {
            return;
        }

        DoublyLinkedList[] halves = l.split();
        mergesort(halves[0]);
        mergesort(halves[1]);
        l.head = merge(halves[0], halves[1]).head;
    }
}
