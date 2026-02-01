import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Market {

    private List<Asset> assets;
    private List<Trader>traders;
    private List<Transaction>transactions;

    public Market(){
        assets=new ArrayList<>();
        traders=new ArrayList<>();
        transactions=new ArrayList<>();
    }

    public void ajouterAsset(Asset actif){
        assets.add(actif);
    }
    public void ajouterTrader(Trader trader){
        traders.add(trader);
    }
    public  void acheter(Trader trader, Asset actif,double quantite){
        trader.acheterAsset(actif,quantite);

        Transaction trans =new Transaction("Achat",actif,quantite,new Date());
        transactions.add(trans);
    }
    public void vendre(Trader trader, Asset actif,double quantite){
        trader.venteAsset(actif,quantite);

        Transaction trans =new Transaction("Vente",actif,quantite,new Date());
        transactions.add(trans);
    }

    public void afficherTransactions(){
        if(transactions.isEmpty()){
            System.out.println("Aucun transaction");
            return;
        }
        for (Transaction t :transactions){
            System.out.println(t.getType()+"-"+t.getActif().getNom()+"-"+t.getQuantite()+"-"+t.getDate());
        }
    }
}
