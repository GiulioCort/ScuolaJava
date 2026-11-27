package esT17_playlist;

public class Playlist {
    private final int MAX_SONG = 4;
    private final int MAX_MINUTI = 15;

    private String nome;
    private Canzone[] lista;

    private int numeroCanzoni;
    private int durata;

    public Playlist(String nome) {
        this.nome = nome;
        lista = new Canzone[MAX_SONG];
        numeroCanzoni = 0;
        durata = 0;
    }

    public boolean aggiungiCanzone(Canzone nuovaCanzone) {
        boolean rit = false;
        int durataNuova = nuovaCanzone.calcolaDurata();
        if (numeroCanzoni < MAX_SONG && durataNuova + durata < MAX_MINUTI * 60) {
            for (int i = 0; i < MAX_SONG && !rit; i++) {
                if (lista[i] == null) {
                    lista[i] = nuovaCanzone;
                    numeroCanzoni++;
                    durata += durataNuova;
                    rit = true;
                }
            }
        }

        return rit;
    }

    private int ricercaCanzone(Canzone canzoneRichiesta) {
        int rit = -1;

        for (int i = 0; i < numeroCanzoni && rit == -1; i++) {
            if (lista[i].equals(canzoneRichiesta)) {rit = i;}
        }

        return rit;
    }

    public boolean eliminaCanzone(Canzone canzoneSelezionata) {
        boolean rit = false;
        int pos = ricercaCanzone(canzoneSelezionata);

        if (numeroCanzoni > 0 && pos != -1) {
            numeroCanzoni--;
            durata -= canzoneSelezionata.calcolaDurata();
            lista[pos] = null;
            rit = true;
        }

        return rit;
    }

    public String suona() {
        String rit = nome + ", " + numeroCanzoni + " Canzoni, " + durata + " secondi";
        for (int i = 0; i < numeroCanzoni; i++) {
            rit += "\n\t" + lista[i].suona();
        }
        return rit;
    }
}