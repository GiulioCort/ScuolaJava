package Esercizio8;

import java.util.Scanner;

public class MainInterattivo {
    public static void main(String[] args) {
        Sveglia[] listaSveglie = new Sveglia[10];
        Scanner scan = new Scanner(System.in);
        int quante = 0;
        char altraSveglia = 's';

        while (altraSveglia == 's' && quante < listaSveglie.length) {
            listaSveglie[quante] = new Sveglia(0, 0);

            System.out.print("Inserisci l'ora: ");
            listaSveglie[quante].setOra(scan.nextInt());
            System.out.print("Inserisci i minuti: ");
            listaSveglie[quante].setMinuti(scan.nextInt());
            System.out.print("Inserisci l'etichetta: ");
            scan.nextLine();
            String etichettaInserita = scan.nextLine();
            if (etichettaInserita.equals("")) {
                listaSveglie[quante].setEtichetta("Senza etichetta");
            } else {
                listaSveglie[quante].setEtichetta(etichettaInserita);
            }

            quante++;

            System.out.print("Un' altra? (s/n): ");
            String altraSvegliaBis = scan.nextLine();
            altraSveglia = altraSvegliaBis.charAt(0);
        }
        int scelta = 0;
        do {
            System.out.println("\n===== MENU =============");
            System.out.println("1) Stampa tutte le sveglie");
            System.out.println("2) Cerca per etichetta");
            System.out.println("3) Modifica");
            System.out.println("4) Posticipa una sveglia");
            System.out.println("5) Fa suonare le sveglie");
            System.out.println("0) Esci dal programma");
            System.out.println("========================");

            System.out.print("\nInserisci la tua scelta: ");
            scelta = scan.nextInt();
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
                    scan.nextLine();
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
                    System.out.print("Numero della sveglia: ");
                    int numeroRichiesto = scan.nextInt();
                    if (numeroRichiesto > 0 && numeroRichiesto <= quante) {
                        Sveglia svegliaCopia = new Sveglia(listaSveglie[numeroRichiesto - 1].getOra(), listaSveglie[numeroRichiesto - 1].getMinuti(), listaSveglie[numeroRichiesto - 1].getEtichetta());

                        System.out.print("Inserisci l'ora: ");
                        listaSveglie[numeroRichiesto - 1].setOra(scan.nextInt());
                        System.out.print("Inserisci i minuti: ");
                        listaSveglie[numeroRichiesto - 1].setMinuti(scan.nextInt());
                        System.out.print("Inserisci l'etichetta: ");
                        scan.nextLine();
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
                    System.out.print("Numero della sveglia: ");
                    int svegliaRichiesta = scan.nextInt();
                    if (svegliaRichiesta > 0 && svegliaRichiesta <= quante) {
                        Sveglia svegliaBis = new Sveglia(listaSveglie[svegliaRichiesta - 1].getOra(), listaSveglie[svegliaRichiesta - 1].getMinuti(), listaSveglie[svegliaRichiesta - 1].getEtichetta());
                        System.out.print("Inserisci i minuti: ");
                        scan.nextLine();
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
                    System.out.print("Ora: ");
                    int oraAttuale = scan.nextInt();
                    System.out.print("Minuti: ");
                    int minutoAttuale = scan.nextInt();

                    for (int i = 0; i < quante; i++) {
                        if (listaSveglie[i].getOra() == oraAttuale &&  listaSveglie[i].getMinuti() == minutoAttuale) {
                            listaSveglie[i].suona();
                        }
                    }
            }

        } while (scelta != 0);
    }
}