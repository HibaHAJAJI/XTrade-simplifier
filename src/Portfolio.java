import java.util.HashMap;
import java.util.Map;

public class Portfolio <T extends Asset> {
    private Map<T, Double>actifs;

    public Portfolio(){
        actifs=new HashMap<>();
    }

    public void ajouterActif(T actif, double quantite){
        if(quantite<=0){
            System.out.println("Quantité invalide!");
            return;
        }
        if(actifs.containsKey(actif)){
            double acQuantite = actifs.get(actif);
            double nQuantite=acQuantite+quantite;
            actifs.put(actif,nQuantite);
        }else {
            actifs.put(actif,quantite);
        }
    }

    public boolean retirerActif(T actif, double quantite) {
        if (!actifs.containsKey(actif)) {
            System.out.println("Asset non trouvée");
            return false;
        } else if(quantite>actifs.get(actif)){
           System.out.println("Quantité insuffisante");
           return false;
       } else if(quantite==actifs.get(actif)){
          actifs.remove(actif);
       }else {
            double noQuantite =actifs.get(actif)-quantite;
            actifs.put(actif,noQuantite);
        }
        return true;
    }

    public double calculerTotal(){
        double total =0;
        for(Map.Entry<T,Double>entry:actifs.entrySet()){
            T actif = entry.getKey();
            double quantite = entry.getValue();
            total += actif.CalculerValeur(quantite);
        }
        return total;
    }

    public void afficherProtflio(){
        if(actifs.isEmpty()){
            System.out.println("Portfolio vide");
            return;
        }
        for (Map.Entry<T,Double>entry: actifs.entrySet()){
            T actif = entry.getKey();
            double quantite = entry.getValue();

            System.out.println("Type :"+actif.getType()+ "Quantité :"+quantite+"Valeur :"+actif.CalculerValeur(quantite));
        }
           System.out.println("Valeur totale :"+calculerTotal());
    }
}
