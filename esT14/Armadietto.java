package esT14;

public class Armadietto {
    private int numero;
    private String contenuto;
    public Armadietto(int numero) {
        this.numero = numero;
        this.contenuto = "vuoto";
    }
    public int getNumero() {
        return numero;
    }
    public String getContenuto() {
        return contenuto;
    }
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    @Override
    public String toString() {
        return numero + " " + contenuto;
    }
}