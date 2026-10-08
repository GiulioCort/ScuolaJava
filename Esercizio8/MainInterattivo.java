package Esercizio8;

import java.util.Scanner;

public class MainInterattivo {
    public static void main(String[] args) {
        Sveglia[] listaSveglie = new Sveglia[10];
        Scanner scan = new Scanner(System.in);
        int quante = 0;
        String altraSveglia = "s";
        boolean corretto;

        while (altraSveglia.equals("s") && quante < listaSveglie.length) {
            int ora, minuti;
            String stringaTemp = "";

            corretto = false;                               // Per entrare nel ciclo
            while (!corretto) {                             // Il ciclo continua fino a quando stringaTemp non è corretta (solo numeri)
                System.out.print("Inserisci l'ora: ");
                stringaTemp = scan.nextLine();
                corretto = true;
                for (int i = 0; i < stringaTemp.length() && corretto; i++) {            // Cicla nella stringa
                    if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {   // Se il carattere non è un numero
                        corretto = false;                                               // segnala che la stringa è errata, uscendo dal ciclo,
                        System.out.print("ERRORE - ");                                  // e stampa ERRORE
                    }
                }
            }
            ora = Integer.parseInt(stringaTemp);

            corretto = false;
            while (!corretto) {
                System.out.print("Inserisci i minuti: ");
                stringaTemp = scan.nextLine();
                corretto = true;
                for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                    if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                        corretto = false;
                        System.out.print("ERRORE - ");
                    }
                }
            }
            minuti = Integer.parseInt(stringaTemp);

            System.out.print("Inserisci l'etichetta: ");
            String etichettaInserita = scan.nextLine();
            if (etichettaInserita.equals("")) {
                listaSveglie[quante] = new Sveglia(ora, minuti);
            } else {
                listaSveglie[quante] = new Sveglia(ora, minuti, etichettaInserita);
            }
            System.out.println(listaSveglie[quante]);
            quante++;

            System.out.print("Un' altra? (s/n): ");
            altraSveglia = scan.nextLine();
        }
        int scelta;
        do {
            corretto = true;
            System.out.println("\n===== MENU =============");
            System.out.println("1) Stampa tutte le sveglie");
            System.out.println("2) Cerca per etichetta");
            System.out.println("3) Modifica");
            System.out.println("4) Posticipa una sveglia");
            System.out.println("5) Fa suonare le sveglie");
            System.out.println("0) Esci dal programma");
            System.out.println("========================");

            System.out.print("\nInserisci la tua scelta: ");
            String stringaTemp = scan.nextLine();
            for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                    corretto = false;
                }
            }
            if (corretto) {scelta = Integer.parseInt(stringaTemp);}
            else {scelta = -1;}
            System.out.println();

            switch (scelta) {
                case 0:
                    System.out.println("Uscita dal programma...");
                    break;
                case 1:
                    for (int i = 0; i < quante; i++) {
                        System.out.println(i + 1 + " - " + listaSveglie[i]);
                    }
                    break;
                case 2:
                    System.out.print("Etichetta che vuoi cercare: ");
                    String etichetteRichiesta = scan.nextLine();

                    int contaSveglie = 0;
                    for (int i = 0; i < quante; i++) {
                        if (listaSveglie[i].getEtichetta().equals(etichetteRichiesta)) {
                            System.out.println(i + 1 + " - " + listaSveglie[i]);
                            contaSveglie++;
                        }
                    }
                    if (contaSveglie == 0) {
                        System.out.println("Non ci sono sveglie con questa etichetta");
                    }
                    break;
                case 3:
                    corretto = false;
                    while (!corretto) {
                        System.out.print("Numero della sveglia: ");
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

                    if (numeroRichiesto > 0 && numeroRichiesto <= quante) {
                        Sveglia svegliaCopia = new Sveglia(listaSveglie[numeroRichiesto - 1].getOra(), listaSveglie[numeroRichiesto - 1].getMinuti(), listaSveglie[numeroRichiesto - 1].getEtichetta());

                        corretto = false;
                        while (!corretto) {
                            System.out.print("Inserisci l'ora: ");
                            stringaTemp = scan.nextLine();
                            corretto = true;
                            for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                                if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                                    corretto = false;
                                    System.out.print("ERRORE - ");
                                }
                            }
                        }
                        listaSveglie[numeroRichiesto - 1].setOra(Integer.parseInt(stringaTemp));

                        corretto = false;
                        while (!corretto) {
                            System.out.print("Inserisci i minuti: ");
                            stringaTemp = scan.nextLine();
                            corretto = true;
                            for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                                if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                                    corretto = false;
                                    System.out.print("ERRORE - ");
                                }
                            }
                        }
                        listaSveglie[numeroRichiesto - 1].setMinuti(Integer.parseInt(stringaTemp));

                        System.out.print("Inserisci l'etichetta: ");
                        String etichettaInserita = scan.nextLine();
                        if (!etichettaInserita.equals("")) {
                            listaSveglie[numeroRichiesto - 1].setEtichetta(etichettaInserita);
                        }

                        System.out.println("Prima --> " + svegliaCopia);
                        System.out.println("Dopo --> " + listaSveglie[numeroRichiesto - 1]);
                    }
                    else {
                        System.out.println("ERRORE, la sveglia " + numeroRichiesto + " non esiste");
                    }
                    break;
                case 4:
                    corretto = false;
                    while (!corretto) {
                        System.out.print("Numero della sveglia: ");
                        stringaTemp = scan.nextLine();
                        corretto = true;
                        for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                            if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                                corretto = false;
                                System.out.print("ERRORE - ");
                            }
                        }
                    }
                    int svegliaRichiesta = Integer.parseInt(stringaTemp);

                    if (svegliaRichiesta > 0 && svegliaRichiesta <= quante) {
                        Sveglia svegliaBis = new Sveglia(listaSveglie[svegliaRichiesta - 1].getOra(), listaSveglie[svegliaRichiesta - 1].getMinuti(), listaSveglie[svegliaRichiesta - 1].getEtichetta());
                        System.out.print("Inserisci i minuti: ");
                        String minutiTemp = scan.nextLine();
                        if (minutiTemp.equals("")) {
                            listaSveglie[svegliaRichiesta - 1].posticipa();
                        } else {
                            int minuti = Integer.parseInt(minutiTemp);
                            listaSveglie[svegliaRichiesta - 1].posticipa(minuti);
                        }

                        System.out.println("Prima --> " + svegliaBis);
                        System.out.println("Dopo --> " + listaSveglie[svegliaRichiesta - 1]);
                    }
                    else {
                        System.out.println("ERRORE, la sveglia " + svegliaRichiesta + " non esiste");
                    }
                    break;
                case 5:
                    System.out.println("Che ore sono?");

                    corretto = false;
                    while (!corretto) {
                        System.out.print("Ora: ");
                        stringaTemp = scan.nextLine();
                        corretto = true;
                        for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                            if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                                corretto = false;
                                System.out.print("ERRORE - ");
                            }
                        }
                    }
                    int oraAttuale = Integer.parseInt(stringaTemp);

                    corretto = false;
                    while (!corretto) {
                        System.out.print("Minuti: ");
                        stringaTemp = scan.nextLine();
                        corretto = true;
                        for (int i = 0; i < stringaTemp.length() && corretto; i++) {
                            if (stringaTemp.charAt(i) < '0' || stringaTemp.charAt(i) > '9') {
                                corretto = false;
                                System.out.print("ERRORE - ");
                            }
                        }
                    }
                    int minutoAttuale = Integer.parseInt(stringaTemp);

                    for (int i = 0; i < quante; i++) {
                        if (listaSveglie[i].getOra() == oraAttuale &&  listaSveglie[i].getMinuti() == minutoAttuale) {
                            listaSveglie[i].suona();
                        }
                    }
                    break;
                default:
                    System.out.println("Comando errato");
            }

        } while (scelta != 0);
    }
}