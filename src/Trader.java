
public class Trader extends Person {
    private  double solde;
    private Portfolio <Asset>portfolio;



    public void effuctuerAchetAsset(Asset actif ,double quantite){
      if(quantite<=0){
          System.out.println("Quantité invalide");
          return;
      }
      double montant =actif.getPrix()*quantite ;
    if(solde>= montant){
        solde -= montant;
        portfolio.ajouterActif(actif,quantite);
        System.out.println("Achat réussi ");
    }else {
        System.out.println("Solde inssufisant !! ");

    }
}

public void effuctuerventeAsset(Asset actif ,double quantite){
     if(quantite<=0){
         System.out.println("Quantité invalide");
         return;
     }

     boolean vendu =portfolio.retirerActif(actif,quantite);

     if (vendu){
         double montant = actif.getPrix()*quantite;
         solde += montant;
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
    public Portfolio<Asset> getPortfolio() {
        return portfolio;
    }


    @Override
    public String toString() {
        return "Trader{" +
                "solde=" + solde +
                ", portfolio=" + portfolio +
                '}';
    }
}

