import java.util.Random;
import java.util.Scanner;

public class Esercizio5 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.print("\n----------------------------------------\n");
        System.out.print("LANCIO DEI DADI\n");
        System.out.print("Scegli il numero di facce\n");
        System.out.print("1) 6 facce\n");
        System.out.print("2) 4 facce\n");
        System.out.print("3) 8 facce\n");
        System.out.print("----------------------------------------\n");
        System.out.print("Inserisci la scelta: ");
        int scelta = scan.nextInt();

        int nFaccie = 0;
        switch (scelta) {
            case 1:
                nFaccie = 6;
                break;
            case 2:
                nFaccie = 4;
                break;
            case 3:
                nFaccie = 8;
                break;
            default:
                System.out.println("!! Opzione non valida !!");
        }

        if (scelta >= 1 && scelta <= 3) {
            System.out.print("Inserisci quanti turni vuoi eseguire: ");
            int n = scan.nextInt();

            int puntiGiocatore = 0;
            int puntiPC = 0;
            int dado;
            for (int i = 1; i <= n; i++) {
                dado = rand.nextInt(nFaccie) + 1;
                puntiGiocatore += dado;
                System.out.println(i + ". Giocatore: " + dado);
                dado = rand.nextInt(nFaccie) + 1;
                puntiPC += dado;
                System.out.println(i + ". PC: " + dado);
            }
            System.out.println("Giocatore: " + puntiGiocatore);
            System.out.println("PC: " + puntiPC);
            if (puntiGiocatore > puntiPC) {
                System.out.println("Vince il giocatore");
            }
            else if (puntiPC > puntiGiocatore) {
                System.out.println("Vince il PC");
            }
            else {
                System.out.println("Parità");
            }
        }
        scan.close();
    }
}
