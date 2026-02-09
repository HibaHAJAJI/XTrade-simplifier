import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private String type;
    private Asset actif;
    private Trader trader;
    private double quantite;
    private LocalDate date;
    private double montant;

    public Transaction(String type, Asset actif, double quantite,Trader trader) {
        this.type = type;
        this.actif = actif;
        this.quantite = quantite;
        this.trader=trader;
        this.date = LocalDate.now();
    }

    public String getType() {
        return type;
    }

    public Asset getActif() {
        return actif;
    }

    public double getQuantite() {
        return quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Trader getTrader() {
        return trader;
    }

    public double getMontant() {
        return actif.getPrix()*montant;
    }

}
