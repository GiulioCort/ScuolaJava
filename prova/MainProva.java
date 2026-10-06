package prova;

import java.util.Scanner;

public class MainProva {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Numero di persone: ");
        int nPersone = scan.nextInt();

        Persona[] listaPersone = new Persona[nPersone];

        for (int i = 0; i < listaPersone.length; i++) {
            System.out.print("Nome: ");
            String nome = scan.next();

            System.out.print("Cognome: ");
            String cognome = scan.next();

            listaPersone[i] = new Persona(nome,  cognome);
            listaPersone[i].ID = i;
        }

        for (int i =  0; i < listaPersone.length; i++) {
            System.out.println(listaPersone[i].ID + "\t" + listaPersone[i].nome + "\t" +  listaPersone[i].cognome);
        }
    }
}
