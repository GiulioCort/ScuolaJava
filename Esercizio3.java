import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float v, vmax, eccesso, p;
        System.out.println("Inserire la tua velocita': ");
        v = scanner.nextFloat();
        System.out.println("Inserire la velocita' massima: ");
        vmax = scanner.nextFloat();
        if (v < 100)
            v = v - 5;
        else {
            p = (v / 100)* 5;
            v = v - p;
        }
        if (v < vmax)
            System.out.println("Velocita' nei limiti");
        else{
            eccesso = v - vmax;
            System.out.println("Eri in eccesso di " + eccesso + " km/h");
            if (eccesso <= 30)
                System.out.println("Devi pagare una multa di 200 euro e ti verranno sottratti 2 punti della patente.");
            else {
                if (eccesso <= 50)
                    System.out.println("Devi pagare una multa di 300 euro e ti verranno sottratti 5 punti della patente.");
                else
                    System.out.println("Devi pagare una multa di 1000 euro e ti verra' ritirata la patente.");
            }
        }
    }
}
