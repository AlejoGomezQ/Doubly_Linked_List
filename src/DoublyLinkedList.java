class Node {
    String data;
    Node prev, next;

    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head, tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    // Método para insertar un nuevo nodo al final de la lista
    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Método para imprimir la lista
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Método para dividir la lista en dos sublistas
    private DoublyLinkedList[] split() {
        DoublyLinkedList[] lists = new DoublyLinkedList[2];
        lists[0] = new DoublyLinkedList();
        lists[1] = new DoublyLinkedList();

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            lists[0].insert(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            lists[1].insert(slow.data);
            slow = slow.next;
        }

        return lists;
    }

    // Método para unir dos listas ordenadas
    private static DoublyLinkedList merge(DoublyLinkedList list1, DoublyLinkedList list2) {
        DoublyLinkedList mergedList = new DoublyLinkedList();

        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data.compareTo(current2.data) <= 0) {
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

    // Método de ordenamiento MergeSort
    public static DoublyLinkedList mergesort(DoublyLinkedList list) {
        if (list.head == list.tail) {
            return list;
        }

        DoublyLinkedList[] lists = list.split();
        DoublyLinkedList firstHalf = mergesort(lists[0]);
        DoublyLinkedList secondHalf = mergesort(lists[1]);

        return merge(firstHalf, secondHalf);
    }
}