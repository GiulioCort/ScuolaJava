package esercizio10;

import java.util.Scanner;

public class MainInterattivo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Televisione[] listaTV = new Televisione[10];
        int quante = 0;
        String altraTV = "s";
        boolean corretto;

        while (altraTV.equals("s") && quante < 10) {
            System.out.print("Inserisci la marca della TV: ");
            String marca = scan.nextLine();
            String stringaTemp = "";

            corretto = false;                               // Per entrare nel ciclo
            while (!corretto) {                             // Il ciclo continua fino a quando stringaTemp non è corretta (solo numeri)
                System.out.print("Inserisci la lunghezza in pollici della diagonale della TV: ");
                stringaTemp = scan.nextLine();
                corretto = true;
                for (int i = 0; i < stringaTemp.length() && corretto; i++) {            // Cicla nella stringa
                    if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {   // Se il carattere non è un numero
                        corretto = false;                                               // segnala che la stringa è errata, uscendo dal ciclo,
                        System.out.print("ERRORE - ");                                  // e stampa ERRORE
                    }
                }
            }
            int pollici = Integer.parseInt(stringaTemp);
            listaTV[quante] = new Televisione(marca, pollici);
            quante++;

            System.out.print("Un' altra? (s/n): ");
            altraTV = scan.nextLine();
        }

        String scelta;
        do {
            corretto = true;
            System.out.println("\n===== MENU =============");
            System.out.println("1) Stampa elenco");
            System.out.println("2) Cerca per marca");
            System.out.println("3) Accendi o spegni");
            System.out.println("4) Cambia canale");
            System.out.println("5) Modificare il volume");
            System.out.println("6) Partita!");
            System.out.println("0) Esci dal programma");
            System.out.println("========================");

            System.out.print("\nInserisci la tua scelta: ");
            scelta = scan.nextLine();
            System.out.println();

            if (scelta.equals("1")) {
                for (int i = 0; i < quante; i++) {System.out.println(i + 1 + ". " + listaTV[i]);}
            }
            else if (scelta.equals("2")) {
                System.out.print("Marca che vuoi cercare: ");
                String marcaRichiesta = scan.nextLine();

                boolean tvPresenti = false;
                for (int i = 0; i < quante; i++) {
                    if (listaTV[i].getMarca().equals(marcaRichiesta)) {
                        System.out.println(i + 1 + " - " + listaTV[i]);
                        tvPresenti = true;
                    }
                }
                if (!tvPresenti) {
                    System.out.println("Non ci sono sveglie con questa etichetta");
                }
            }
            else if (scelta.equals("3")) {
                String stringaTemp = "";
                corretto = false;
                while (!corretto) {
                    System.out.print("Numero della tv: ");
                    stringaTemp = scan.nextLine();
                    corretto = true;
                    for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                        if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                            corretto = false;
                            System.out.print("ERRORE - ");
                        }
                    }
                }
                int numeroRichiesto = Integer.parseInt(stringaTemp);

                System.out.print("a/s: ");
                String azione = scan.nextLine();

                System.out.println("Prima: " + listaTV[numeroRichiesto - 1]);

                if (azione.equals("a")) {listaTV[numeroRichiesto - 1].accendi();}
                else if (azione.equals("s")) {listaTV[numeroRichiesto - 1].spegni();}
                else {System.out.println("ERRORE - Inserisci a / s");}

                System.out.println("Dopo: " + listaTV[numeroRichiesto - 1]);
            }
            else if (scelta.equals("4")) {
                String stringaTemp = "";
                corretto = false;
                while (!corretto) {
                    System.out.print("Numero della tv: ");
                    stringaTemp = scan.nextLine();
                    corretto = true;
                    for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                        if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                            corretto = false;
                            System.out.print("ERRORE - ");
                        }
                    }
                }
                int numeroRichiesto = Integer.parseInt(stringaTemp);

                corretto = false;
                while (!corretto) {
                    System.out.print("Canale: ");
                    stringaTemp = scan.nextLine();
                    corretto = true;
                    for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                        if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                            corretto = false;
                            System.out.print("ERRORE - ");
                        }
                    }
                }
                int canale = Integer.parseInt(stringaTemp);

                System.out.println("Prima: " + listaTV[numeroRichiesto - 1]);
                listaTV[numeroRichiesto - 1].cambiaCanale(canale);
                System.out.println("Dopo: " + listaTV[numeroRichiesto - 1]);
            }
            else if (scelta.equals("5")) {
                String stringaTemp = "";
                corretto = false;
                while (!corretto) {
                    System.out.print("Numero della tv: ");
                    stringaTemp = scan.nextLine();
                    corretto = true;
                    for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                        if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                            corretto = false;
                            System.out.print("ERRORE - ");
                        }
                    }
                }
                int numeroRichiesto = Integer.parseInt(stringaTemp);

                System.out.println("Prima: " + listaTV[numeroRichiesto - 1]);

                System.out.print("+ alzare\n- abbassare\nm muto: ");
                String azione = scan.nextLine();

                if (azione.equals("+")) {
                    System.out.print("Quanto? (lascia vuoto per aumentare di 1): ");
                    String risposta = scan.nextLine();
                    if (risposta.isEmpty()) {listaTV[numeroRichiesto - 1].alzaVolume();}
                    else {
                        listaTV[numeroRichiesto - 1].alzaVolume(Integer.parseInt(risposta));
                    }
                }
                else if (azione.equals("-")) {listaTV[numeroRichiesto - 1].abbassaVolume();}
                else if (azione.equals("m")) {listaTV[numeroRichiesto - 1].attivaMuto();}
                else {System.out.println("ERRORE - Valore non valido");}

                System.out.println("Dopo: " + listaTV[numeroRichiesto - 1]);
            }
            else if (scelta.equals("6")) {
                String stringaTemp = "";
                corretto = false;
                while (!corretto) {
                    System.out.print("Numero della tv: ");
                    stringaTemp = scan.nextLine();
                    corretto = true;
                    for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                        if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                            corretto = false;
                            System.out.print("ERRORE - ");
                        }
                    }
                }
                int numeroRichiesto = Integer.parseInt(stringaTemp);

                for (int i = 0; i < quante; i++) {
                    if (i != numeroRichiesto - 1) {listaTV[i].sintonizzaCome(listaTV[numeroRichiesto - 1]);}
                    System.out.println(i + 1 + ". " + listaTV[i]);
                }
            }
            else if (scelta.equals("0")) {System.out.println("Uscita dal programma...");}
            else {System.out.println("Comando errato");}
        } while (!scelta.equals("0"));
    }
}
