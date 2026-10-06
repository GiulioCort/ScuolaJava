package esercizioCorreggiCodice.A;

class Sveglia {
    private int ora;
    private int minuti;
    private String etichetta;

    public Sveglia(int ora, int minuti, String etichetta) {     // Costruttore
        this.etichetta = etichetta;

        if (ora >= 0 && ora <= 23)
            this.ora = ora;
        else
            this.ora = 7;

        if (minuti >= 0 && minuti <= 59)
            this.minuti = minuti;
        else
            this.minuti = 0;
    }
    public Sveglia(int ora, int minuti) {       // Costruttore 2
        this(ora, minuti, "senza etichetta");
    }

    public void suona() {
        System.out.println("DRIIIN!");
    }

    public void posticipa(int minuti) {
        if (minuti < 0)
            System.out.println("ERRORE, minuti inseriti sotto lo 0");
        else if (minuti == 0)
            System.out.println("ERRORE, minuti inseriti uguale a 0");
        else {
            this.minuti += minuti;
            while (this.minuti > 59){
                this.ora++;
                this.minuti -= 60;
            }

            if (this.ora > 23) {
                this.ora -= 24;
            }
        }
    }

    public void posticipa() {
        posticipa(5);
    }

    @Override
    public String toString() {
        return "Sveglia alle " + ora + ":" + minuti + " (" + etichetta + ")";
    }

    public int getOra() {return ora;}
    public int getMinuti() {return minuti;}
    public String getEtichetta() {return etichetta;}

    public void setOra(int ora) {
        if (ora >= 0 && ora <= 23)
            this.ora = ora;
        else
            System.out.println("ERRORE, ora non valida");
    }
    public void setMinuti(int minuti) {
        if (minuti >= 0 && minuti <= 59)
            this.minuti = minuti;
        else
            System.out.println("ERRORE, minuti non validi");
    }
    public void setEtichetta(String etichetta) {
        this.etichetta = etichetta;
    }
}
