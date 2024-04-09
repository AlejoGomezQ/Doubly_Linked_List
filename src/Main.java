

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(12);
        list.insert(7);
        list.insert(14);
        list.insert(5);
        list.insert(9);
        list.insert(11);
        list.insert(6);
        list.insert(20);
        list.insert(-1);

        System.out.println("Lista antes de ordenar:");
        list.display();

        DoublyLinkedList.mergesort(list);

        System.out.println("Lista después de ordenar:");
        list.display();
    }
}