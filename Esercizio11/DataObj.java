package Esercizio11;

public class DataObj {
    private int giorno;
    private int mese;
    private int anno;

    // Costruttori
    public DataObj(int giorno, int mese, int anno) {
        if (controlloData(giorno, mese, anno) && anno < 2027) {
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
        } else {
            System.out.println("Valori non validi");
            this.giorno = 1;
            this.mese = 1;
            this.anno = 2026;
        }
    }

    public DataObj() {
        giorno = 1;
        mese = 1;
        anno = 1900;
    }

    public DataObj(DataObj n) {
        this.giorno = n.giorno;
        this.mese = n.mese;
        this.anno = n.anno;
    }

    // setter e getter
    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }
    public void setMese(int mese) {
        this.mese = mese;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public int getAnno() {
        return anno;
    }
    public int getGiorno() {
        return giorno;
    }
    public int getMese() {
        return mese;
    }

    public static boolean controlloData(int giorno, int mese, int anno) {
        boolean f = true;
        int[] giorniMese = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (mese < 1 || mese > 12) {
            f = false;
        }
        if (anno < 1) {
            f = false;
        }
        if (mese == 2 && ((anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0))) {
            giorniMese[1] = 29;
        }
        if (giorno < 1 || giorno > giorniMese[mese - 1]) {
            f = false;
        }
        return f;
    }

    @Override
    public String toString() {
        return giorno + "/" + mese + "/" + anno;
    }

    public String toStringal() {
        String[] alfa = {"Gennaio", "Febbraio", " Marzo", " Aprile", "Maggio", " Giugno", "Luglio", " Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
        return giorno + " " + alfa[mese - 1] + " " + anno;
    }

    public boolean equals(DataObj n) {
        boolean f = false;
        if (this.giorno == n.giorno && this.mese == n.mese && this.anno == n.anno) {
            f = true;
        }
        return f;
    }
}