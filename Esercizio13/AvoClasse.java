package Esercizio13;

public class AvoClasse {
    private final int MAX = 30;

    private int numeroStudenti;
    private Studente[] listaStudenti;
    private String classe;

    public AvoClasse(int numeroStudenti, Studente[] listaStudenti, String classe) {
        this.numeroStudenti = numeroStudenti;
        this.classe = classe;
        this.listaStudenti = listaStudenti;
    }

    public AvoClasse() {
        this.numeroStudenti = 0;
        this.classe = "";
        this.listaStudenti = new Studente[MAX];
        for (int i = 0; i < MAX; i++) {
            this.listaStudenti[i] = new Studente();
        }
    }

    public AvoClasse(AvoClasse altra) {
        this.numeroStudenti = altra.numeroStudenti;
        this.classe = altra.classe;
        for (int i = 0; i < MAX; i++) {
            this.listaStudenti[i] = new Studente(altra.listaStudenti[i]);
        }
    }

    public int getNumeroStudenti() {return numeroStudenti;}
    public String getClasse() {return classe;}
    public Studente[] getListaStudenti() {return listaStudenti;}

    public void setNumeroStudenti(int numeroStudenti) {
        this.numeroStudenti = numeroStudenti;
    }
    public void setClasse(String classe) {
        this.classe = classe;
    }
    public void setListaStudenti(Studente[] listaStudenti) {
        this.listaStudenti = listaStudenti;
    }

    @Override
    public String toString(){
        String temp = classe + " --> " + numeroStudenti + " studenti: ";

        for (int i = 0; i < numeroStudenti; i++) {
            temp +=  "\n\t" + listaStudenti[i];
        }

        return temp;
    }

    public boolean equals(AvoClasse altra) {
        boolean rit = false;
        if (numeroStudenti == altra.numeroStudenti && classe.equals(altra.classe)){
            rit = true;
            for (int i = 0; i < MAX; i++) {
                if (!listaStudenti[i].equals(altra.listaStudenti[i])){
                    rit = false;
                }
            }
        }
        return rit;
    }

    public void inserimento(Studente nuovoStudente) {
        if (numeroStudenti < MAX) {
            this.listaStudenti[numeroStudenti] = new Studente(nuovoStudente);
            this.numeroStudenti++;
        }
    }

    public int ricerca(Studente studenteCercato) {
        int rit = -1;
        for (int i = 0; i < numeroStudenti; i++) {
            if (this.listaStudenti[i].equals(studenteCercato)) {rit = i;}
        }

        return rit;
    }

    public void eliminazione(Studente studenteRichiesto) {
        int indiceRichiesto = ricerca(studenteRichiesto);

        numeroStudenti--;
        for (int i = indiceRichiesto; i < numeroStudenti; i++) {
            listaStudenti[i] = listaStudenti[i + 1];
        }
        listaStudenti[numeroStudenti] = null;

    }
}
