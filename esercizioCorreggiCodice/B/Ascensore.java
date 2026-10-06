package esercizioCorreggiCodice.B;

class Ascensore {
    private int piano;
    private int capienza;
    private int ultimoPiano;

    public Ascensore(int cap, int ultimo) {
        piano = 0;
        capienza = cap;
        ultimoPiano = ultimo;
    }

    void sali() {
        if (piano < ultimoPiano) {
            piano = piano + 1;
            System.out.println("Salgo al piano " + piano);
        }
        else  {
            System.out.println("ERRORE, piano non valido");
        }
    }
    void scendi() {
        if (piano > 0) {
            piano = piano - 1;
            System.out.println("Scendo al piano " + piano);
        }
        else  {
            System.out.println("ERRORE, piano non valido");
        }
    }

    public int getPiano() {return piano;}
    public int getCapienza() {return capienza;}
    public int getUltimoCapienza() {return ultimoPiano;}

    public void setUltimoPiano(int ult) {ultimoPiano = ult;}

    void apriPorte() {
        System.out.println("Porte aperte");
    }
}