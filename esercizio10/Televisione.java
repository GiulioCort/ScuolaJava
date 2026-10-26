package esercizio10;

public class Televisione {
    private String marca;
    private int pollici;
    private boolean accesa;
    private int canale;
    private int volume;
    private boolean muto;

    public Televisione (String marca, int pollici) {
        this.marca = marca;
        this.pollici = pollici;
        accesa = false;
        canale = 1;
        volume = 10;
        muto = false;
    }

    public String getMarca() {return marca;}
    public int getPollici() {return pollici;}
    public int getCanale() {return canale;}
    public int getVolume() {return volume;}

    public void accendi() {
        if (accesa) {System.out.println("ERRORE, TV già accesa");}
        else {
            System.out.println("ON");
            accesa = true;
        }
    }
    public void spegni() {
        if (!accesa) {System.out.println("ERRORE, TV già spenta");}
        else {
            System.out.println("OFF");
            accesa = false;
        }
    }

    public void cambiaCanale(int canale) {
        if (canale >= 1 && canale <= 999 && accesa) {this.canale = canale;}
        else if (!accesa) {System.out.println("ERRORE, TV spenta");}
        else {System.out.println("ERRORE, canale non trovato");}
    }

    public void sintonizzaCome(Televisione altraTV) {
        cambiaCanale(altraTV.getCanale());
    }

    public void alzaVolume(int volume) {
        if (accesa) {
            muto = false;
            this.volume += volume;
            if (this.volume < 0) {
                this.volume = 0;
            } else if (this.volume > 100) {
                this.volume = 100;
            }
        }
        else {System.out.println("ERRORE, TV spenta");}
    }
    public void alzaVolume() {alzaVolume(1);}
    public void abbassaVolume() {alzaVolume(-1);}
    public void abbassaVolume(int volume) {alzaVolume(-volume);}

    public void attivaMuto() {
        if (accesa) {muto = true;}
        else {System.out.println("ERRORE, TV spenta");}
    }

    @Override
    public String toString() {
        String seAccesa, seMuto = "";
        if (accesa) {seAccesa = "accesa";}
        else {seAccesa = "spenta";}

        if (muto) {seMuto = ", muto";}

        return marca + " " + pollici + " pollici [" + seAccesa + "] canale " + canale + ", volume " + volume + seMuto;
    }
}