import java.util.Date;

public class Transaction {
    private String type;
    private Asset actif;
    private Trader trader;
    private double quantite;
    private Date date;

    public Transaction(String type, Asset actif, double quantite, Date date) {
        this.type = type;
        this.actif = actif;
        this.quantite = quantite;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }
}
