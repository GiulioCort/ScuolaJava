import java.util.Scanner;

public class Esercizio7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nVocali = 0, nConsonanti = 0, nNumeri = 0, nSpazi = 0, nParole = 0;

        System.out.print("Inserici una frase: ");
        String frase = scan.nextLine();

        System.out.println("Lunghezza: " + frase.length());

        String fraseMinuscola = frase.toLowerCase();
        String fraseMaiuscola = frase.toUpperCase();
        String[] fraseSplit = frase.split(" ");
        char lettera;

        for (int i = 0; i < frase.length(); i++) {
            if (fraseMinuscola.charAt(i) == 'a' ||  fraseMinuscola.charAt(i) == 'e' || fraseMinuscola.charAt(i) == 'i' || fraseMinuscola.charAt(i) == 'o' || fraseMinuscola.charAt(i) == 'u') {
                nVocali++;
            }
            else if (fraseMinuscola.charAt(i) >= 'a' && fraseMinuscola.charAt(i) <= 'z') {
                nConsonanti++;
            }
            else if (fraseMinuscola.charAt(i) >= '0' &&  fraseMinuscola.charAt(i) <= '9') {
                nNumeri++;
            }
            else if (frase.charAt(i) == ' ') {
                nSpazi++;
            }
        }

        System.out.println("Vocali: " + nVocali);
        System.out.println("Consonanti: " + nConsonanti);
        System.out.println("Numeri: " + nNumeri);
        System.out.println("Spazi: " + nSpazi);

        System.out.println("Frase maiuscola --> " + fraseMaiuscola);
        System.out.println("Frase minuscola --> " + fraseMinuscola);

        nParole = nSpazi + 1;
        System.out.println("Numero di parole (no split): " + nParole);
        System.out.println("Numero di parole (split): " + fraseSplit.length);

        for (int i = 0; i < frase.length(); i++) {
            lettera = frase.charAt(i);

            if ((i - 1 >= 0 && frase.charAt(i - 1) == ' ' && frase.charAt(i) != ' ') || i == 0 && frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z') {
                lettera -= 32;
            }

            System.out.print(lettera);
        }
    }
}
