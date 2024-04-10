import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> nombresCompletos = GeneradorADTs.generar(10);

        DoublyLinkedList listaPersonas = new DoublyLinkedList();
        for (String nombreCompleto : nombresCompletos) {
            String[] partes = nombreCompleto.split(" ");
            String nombre1 = partes[0];
            String nombre2 = partes[1];
            String apellido1 = partes[2];
            String apellido2 = partes[3];
            listaPersonas.insert(new Person(nombre1 + " " + nombre2 + "", apellido1 + " " + apellido2 + ",").toString());
        }

        System.out.println("Lista sin ordenar:");
        listaPersonas.display();

        System.out.println("Lista ordenada:");
        DoublyLinkedList listaOrdenada = DoublyLinkedList.mergesort(listaPersonas);
        listaOrdenada.display();
    }
}