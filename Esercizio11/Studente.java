package Esercizio11;

public class Studente {
    private String nome;
    private String cognome;
    private DataObj dataDiNascita;
    private int classe;
    private String sezione;
    private DataObj dataIscrizione;

    // Costruttori
    public Studente(String nome, String cognome, DataObj dataDiNascita, int classe, String sezione, DataObj dataIscrizione) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.classe = classe;
        this.sezione = sezione;
        this.dataIscrizione = dataIscrizione;
    }
    public Studente() {
        this("NomeProva", "CognomeProva", new DataObj(), 1, "A", new DataObj());
    }
    public Studente(Studente altroStudente) {
        this(altroStudente.nome, altroStudente.cognome, new DataObj(altroStudente.dataDiNascita), altroStudente.classe, altroStudente.sezione, new DataObj(altroStudente.dataIscrizione));
    }

    // getter e setter
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}

    public DataObj getDataDiNascita() {return dataDiNascita;}
    public void setDataDiNascita(DataObj dataDiNascita) {
        this.dataDiNascita = new DataObj(dataDiNascita.getGiorno(), dataDiNascita.getMese(), dataDiNascita.getAnno());
    }

    public int getClasse() {return classe;}
    public void setClasse(int classe) {this.classe = classe;}

    public String getSezione() {return sezione;}
    public void setSezione(String sezione) {this.sezione = sezione;}

    public DataObj getDataIscrizione() {return dataIscrizione;}
    public void setDataIscrizione(DataObj dataIscrizione) {
        this.dataIscrizione = new DataObj(dataIscrizione.getGiorno(), dataIscrizione.getMese(), dataIscrizione.getAnno());
    }

    // metodi aggiuntivi : toString , equals
    @Override
    public String toString() {
        return "Nome: " + nome +  ", cognome: " + cognome + ", data di nascita: " + dataDiNascita + ", classe: " + classe + ", sezione: " + sezione + ", dataIscrizione: " + dataIscrizione;
    }

    public boolean equals(Studente altro) {
        boolean rit = false;
        if (this.nome.equals(altro.nome) && this.cognome.equals(altro.cognome) && this.dataDiNascita.equals(altro.dataDiNascita) && this.classe == altro.classe && this.sezione.equals(altro.sezione) && this.dataIscrizione.equals(altro.dataIscrizione))
            rit = true;

        return rit;
    }
}