package esT17_playlist;

public class Canzone {
    private String titolo;
    private String cantante;
    private int minuti;
    private int secondi;
    private int contatore;

    public Canzone(String titolo, String cantante, int minuti, int secondi) {
        this.titolo = titolo;
        this.cantante = cantante;
        this.minuti = minuti;
        this.secondi = secondi;
        this.contatore = 0;
        if (!controlloDurata()) {
            this.minuti = 3;
            this.secondi = 0;
        }
    }

    public boolean controlloDurata() {
        boolean rit = true;
        if ((this.minuti == 0 && this.secondi == 0) || this.minuti < 0 || this.secondi < 0) {rit = false;}
        return rit;
    }

    public String suona() {
        this.contatore++;
        return toString() + " " + contatore + " volte.";
    }

    public int calcolaDurata() {
        return this.minuti * 60 + this.secondi;
    }

    public boolean equals(Canzone altra) {
        boolean rit = false;
        if (titolo.equals(altra.titolo) && cantante.equals(altra.cantante) && minuti == altra.minuti && secondi == altra.secondi) {rit = true;}

        return rit;
    }

    @Override
    public String toString() {
        return titolo + " " + cantante + " " + minuti + ":" + secondi;
    }

}
