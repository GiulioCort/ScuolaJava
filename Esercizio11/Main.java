package Esercizio11;

public class Main {
    public static void main(String[] args) {
        DataObj data = new DataObj(3, 7, 2009);
        DataObj data2 = new DataObj();
        Studente s1 = new Studente("Giulio", "Cortese", data, 4, "B", data2);
        Studente s2 = new Studente();

        System.out.println("1. " + s1);
        System.out.println("2. " + s2);

        data2.setAnno(2023);
        s1.setDataDiNascita(data2);
        System.out.println("1. " + s1);

        Studente s3 = new Studente(s1);
        System.out.println("3. " + s3);
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s1.equals(s3));
    }
}
