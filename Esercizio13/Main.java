package Esercizio13;

public class Main {
    public static void main(String[] args) {
        DataObj data = new DataObj(3, 7, 2009);
        Studente s1 = new Studente("Giulio", "Cortese", data, 4, "B", data);
        DataObj data2 = new DataObj(7, 1, 2009);
        Studente s2 = new Studente("Andrea Bruno", "Savarino", data2, 4, "B", data);

        Studente[] lista = {s1, s2};
        AvoClasse classe1 = new AvoClasse(2, lista, "4B Informatica");
        System.out.println(classe1);

        AvoClasse classe3 = new AvoClasse();
        System.out.println(classe3);


    }
}
