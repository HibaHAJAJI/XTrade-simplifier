
public class Trader extends Person {
    private  double solde;
    private Portfolio <Asset>portfolio;



    public void acheterAsset(Asset actif ,double quantite){
      if(quantite<=0){
          System.out.println("Quantité invalide");
          return;
      }
      double buy =actif.getPrix()*quantite ;
    if(solde>=buy){
        solde -=buy;
        portfolio.ajouterActif(actif,quantite);
        System.out.println("Achat réussi ");
    }else {
        System.out.println("Solde inssufisant !! ");

    }
}

public void venteAsset(Asset actif ,double quantite){
     if(quantite<=0){
         System.out.println("Quantité invalide");
         return;
     }

     boolean vendu =portfolio.retirerActif(actif,quantite);

     if (vendu){
         double mantant = actif.getPrix()*quantite;
         solde += mantant;
         System.out.println("Vente réussie");
     }
}


    public Trader(int id, String nom, double solde) {
        super(id, nom);
        this.solde = solde;
        this.portfolio=new Portfolio<>();
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Portfolio<Asset> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio<Asset> portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "solde=" + solde +
                ", portfolio=" + portfolio +
                '}';
    }
}

