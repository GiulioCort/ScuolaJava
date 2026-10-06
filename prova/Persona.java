package prova;

public class Persona {
    int ID;
    String nome;
    String cognome;
    int eta;

    public Persona(String n, String cN) {
        nome = n;
        cognome = cN;
    }

    void saluta() {
        System.out.println(nome + " ti saluta");
    }
}
