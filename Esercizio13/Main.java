package Esercizio13;

public class Main {
    public static void main(String[] args) {
        DataObj data = new DataObj(3, 7, 2009);
        Studente sA = new Studente("Giulio", "Cortese", data, 4, "B", data);
        DataObj data2 = new DataObj(7, 1, 2009);
        Studente sB = new Studente("Bruno", "Bianchi", data2, 4, "B", data);
        Studente sC = new Studente("Luca", "Verdi", data, 4, "B", data);
        Studente sD = new Studente("Francesco", "Rossi", data, 4, "B", data);

        AvoClasse classe = new AvoClasse();
        classe.setClasse("4B Info");

        classe.inserimento(sA);
        classe.inserimento(sB);
        classe.inserimento(sC);
        classe.inserimento(sD);

        System.out.println(classe);

        classe.eliminazione(sD);
        System.out.println(classe);
    }
}
