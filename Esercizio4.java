import java.util.Scanner;

public class Esercizio4 {       // Progressione aritmetica
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        System.out.println("Inserisci tre numeri: ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        if (n3 - n2 == n2 - n1) {
            System.out.println("I numeri inseriti sono in progressione aritmetica.");
        }
        else {
            System.out.println("I numeri inseriti NON sono in progressione aritmetica.");
        }

        scanner.close();
    }
}
