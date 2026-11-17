package esT14;

public class CorridoioTestDrive {
    public static void main(String[] args) {
        Armadietto[] corridoio = new Armadietto[4];
        Armadietto x = new Armadietto(7);
        Armadietto y = new Armadietto(12);
        corridoio[0] = x;

        corridoio[1] = new Armadietto(3);

        corridoio[2] = y;
        corridoio[3] = corridoio[1];
        x = corridoio[2];
        corridoio[1] = null;
        y = new Armadietto(21);
        corridoio[2] = corridoio[0];
        corridoio[3] = y;
        x.setContenuto("zaino");
        corridoio[2].setContenuto("pallone");
        // FINE

        System.out.println(corridoio[0].getContenuto());
        System.out.println(corridoio[1].getNumero());
        System.out.println(x == corridoio[2]);

    }
}