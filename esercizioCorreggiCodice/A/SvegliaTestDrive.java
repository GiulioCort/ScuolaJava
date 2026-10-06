package esercizioCorreggiCodice.A;

class SvegliaTestDrive {
    public static void main(String[] args) {
        Sveglia scuola = new Sveglia(7, 30, "Scuola");
        Sveglia pisolino = new Sveglia(15, 0);
        System.out.println(scuola);
        System.out.println(pisolino);

        scuola.posticipa();
        System.out.println(scuola);
        scuola.posticipa(20);
        System.out.println(scuola);
        scuola.posticipa(0);

        Sveglia medicina = new Sveglia(23, 50, "Medicina");
        medicina.posticipa(15);
        System.out.println(medicina);
    }
}