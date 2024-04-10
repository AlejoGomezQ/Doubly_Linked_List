import edu.princeton.cs.algs4.StdOut;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> personas = GeneradorADTs.generar(10);
        DoublyLinkedList list = new DoublyLinkedList();
        for (String p : personas)
            list.insert(p);

        System.out.println("Lista antes de ordenar:");
        list.display();

        DoublyLinkedList.mergesort(list);

        System.out.println("Lista después de ordenar:");
        list.display();
    }
}