package unaClasseMoltiOggetti;

public class Recensione {
    private String locale;
    private String autore;
    private int stelle;

    void pubblica() {
        System.out.println(autore + " ha dato " + stelle + " stelle a " + locale);
    }

    String getLocale() {return locale;}
    String getAutore() {return autore;}
    int getStelle() {return stelle;}

    void setLocale(String locale) {this.locale = locale;}
    void setAutore(String autore) {this.autore = autore;}
    void setStelle(int stelle) {
        if (stelle >= 1 && stelle <= 5) {this.stelle = stelle;}
        else {
            System.out.println("Recensione non valida (" +  stelle + ")");
        }
    }

    public Recensione(String locale, String autore, int stelle) {       // Costruttore
        this.locale = locale;
        this.autore = autore;
        this.stelle = stelle;
    }

    @Override
    public String toString() {
        return this.autore + " ha dato " + this.stelle + " stelle a " + this.locale;
    }
}
