package esT17_playlist;

public class RadioIntervallo {
    public static void main(String[] args) {
        Canzone cA = new Canzone("Campanella", "I Pendolari", 3, 12);
        Canzone cB = new Canzone("Ultima fila", "I Pendolari", 4, 5);
        Canzone cC = new Canzone("Interrogato", "MC Verifica", 2, 58);
        Canzone cD = new Canzone("Ricreazione", "Lady Merenda", 0, 0);
        Canzone cE = new Canzone("Nebbia in tangenziale", "I Lampioni", 4, 41);
        Canzone cF = new Canzone("Caffè delle sette", "Trio Moka", 5, 20);
        Canzone cG = new Canzone("Intro", "Gli Assenti", 1  , 15);

        Playlist plA = new Playlist("4B carica");
        plA.aggiungiCanzone(cA);
        plA.aggiungiCanzone(cE);
        plA.aggiungiCanzone(cF);
        plA.aggiungiCanzone(cG);
        plA.aggiungiCanzone(cB);
        System.out.println(plA.suona());
    }
}
