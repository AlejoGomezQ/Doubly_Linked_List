import java.text.DecimalFormat;

class Person implements Comparable<Person> {

    private String nombres;
    private String apellidos;

    public Person(String n, String a, int e, float p) {
        nombres = n;
        apellidos = a;
    }

    public String toString() {
        return nombres + " " + apellidos;
    }

    @Override
    public int compareTo(Person o) {
        // TODO Auto-generated method stub
        return 0;
    }

    private static final DecimalFormat df = new DecimalFormat();
    {
        df.setMaximumFractionDigits(2);
    }

}