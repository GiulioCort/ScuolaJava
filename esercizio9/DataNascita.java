package esercizio9;

public class DataNascita {
    private int giorno;
    private int mese;
    private int anno;

    public void setGiorno(int giorno) {this.giorno = giorno;}
    public void setMese(int mese) {this.mese = mese;}
    public void setAnno(int anno) {this.anno = anno;}

    public int getGiorno() {return giorno;}
    public int getMese() {return mese;}
    public int getAnno() {return anno;}

    @Override
    public String toString() {return giorno + "/" +  mese + "/" + anno;}

    public String toStringAlfabetico() {
        String[] listaMesi = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
        String ritorno;
        if (mese > 0 && mese <= 12) {ritorno = giorno + " " + listaMesi[mese - 1] + " " + anno;}
        else {ritorno = "ERRORE";}

        return ritorno;
    }

    public boolean controlloData() {
        boolean isCorretto = true;
        int[] giorniMesi = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (mese <= 0 || mese > 12 || anno > 2026) {
            isCorretto = false;
        }
        else if (giorno > giorniMesi[mese - 1] || giorno <= 0) {isCorretto = false;}

        return isCorretto;
    }
}
