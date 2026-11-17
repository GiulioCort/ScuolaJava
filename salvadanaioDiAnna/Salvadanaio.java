package salvadanaioDiAnna;

import java.util.Scanner;

public class Salvadanaio {
    private String proprietario;
    private int monete;
    private int[] settimana;

    public Salvadanaio(String proprietario) {
        this.proprietario = proprietario;
        this.settimana = new int[7];
    }
    public Salvadanaio(Salvadanaio altro) { // costruttore copia
        this.proprietario = altro.proprietario;
        this.monete = altro.monete;
        this.settimana = new int[7];
        for (int i = 0; i < 7; i++) {this.settimana[i] = altro.settimana[i];}
    }

    public String getProprietario() {
        return proprietario;
    }
    public int getMonete() {
        return monete;
    }

    public void setMonete(int monete) {
        this.monete = monete;
    }

    public void versa(int giorno, int quante) {
        settimana[giorno] = settimana[giorno] + quante;
        monete = monete + quante;
    }
    public int getVersatoIl(int giorno) {
        return settimana[giorno];
    }

    public static void main(String[] args) {
        Salvadanaio a = new Salvadanaio("Anna");
        a.versa(0, 10); // lunedì
        Salvadanaio c = new Salvadanaio(a);
        c.versa(2, 1); // mercoledì, solo nella copia

        System.out.println("a: " + a.getMonete() + " monete, mercoledì " + a.getVersatoIl(2));
        System.out.println("c: " + c.getMonete() + " monete, mercoledì " + c.getVersatoIl(2));
    }
}
