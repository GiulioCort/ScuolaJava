package prova;

public class Interruttore {
    private boolean acceso;

    private void setAcceso(boolean a) {
        acceso = a;
    }
    public boolean getAcceso() {
        return acceso;
    }

    public void accendi() {
        acceso = true;
    }
    public void spegni() {
        acceso = false;
    }

    public static void main(String[] args) {
        Interruttore i = new Interruttore();

        i.accendi();
        System.out.println(i.getAcceso());
        i.spegni();
        System.out.println(i.getAcceso());
    }
}
