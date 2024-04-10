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
            // Asumiendo que edad y peso son aleatorios
            int edad = (int) (Math.random() * 100);
            float peso = (float) (Math.random() * 100);
            listaPersonas.insert(new Person(nombre1 + " " + nombre2 + " " + apellido1 + " " + apellido2, "", edad, peso).toString());
        }

        System.out.println("Lista sin ordenar:");
        listaPersonas.display();

        System.out.println("Lista ordenada:");
        DoublyLinkedList listaOrdenada = DoublyLinkedList.mergesort(listaPersonas);
        listaOrdenada.display();
    }
}