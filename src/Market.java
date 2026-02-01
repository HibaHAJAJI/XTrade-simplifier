import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Market {

    private List<Asset> assets;
    private List<Trader>traders;
    private List<Transaction>transactions;
    private Scanner sc;

    public Market(){
        assets=new ArrayList<>();
        traders=new ArrayList<>();
        transactions=new ArrayList<>();
        sc=new Scanner(System.in);
    }

    public void ajouterAsset(){
        System.out.println("===== Ajouter Asset =====");
        int typeAsset =0;
        do {
            try {
                System.out.println("1. Stock");
                System.out.println("2. CryptoCurrency");
                System.out.print("Choisir le type : ");
                typeAsset = sc.nextInt();
                sc.nextLine();
            }catch (Exception e){
                System.out.println("Error: la chaîne de caractères n'est pas un nombre valide.");
            }
        }while (typeAsset!=1 && typeAsset!=2);
        System.out.println("Entrer Code :");
        int code= sc.nextInt();
        sc.nextLine();
        System.out.println("Entrer Nom :");
        String nom=sc.nextLine();
        System.out.println("Entrer le prix :");
        double prix = sc.nextDouble();

        Asset actif;
        if(typeAsset==1){
            actif=new Stock(code,nom,prix);
        } else {
            actif=new Stock(code,nom,prix);
        }

        assets.add(actif);
        System.out.println("Asset ajouté ✔️");
    }


    public void ajouterTrader(){
        System.out.println("=====Ajouter Trader=====");
        System.out.println("Entrer ID :");
        int id= sc.nextInt();
        sc.nextLine();//espace
        System.out.println("Entrer le Nom :");
        String nom =sc.nextLine();
        System.out.println("Entrer Solde initial :");
        double solde= sc.nextDouble();
        Trader trader= new Trader(id,nom,solde);
        traders.add(trader);
        System.out.println("Trader ajouté ✔️");
    }
    public  void acheter(Trader trader, Asset actif,double quantite){
        System.out.println("Market: demande d'achat");
        trader.acheterAsset(actif,quantite);

        Transaction trans =new Transaction("Achat",actif,quantite,new Date());
        transactions.add(trans);
        System.out.println("Market: transaction enregistrée");

    }
    public void vendre(Trader trader, Asset actif,double quantite){
        System.out.println("Market: demande de vendre");

        trader.venteAsset(actif,quantite);

        Transaction trans =new Transaction("Vente",actif,quantite,new Date());
        transactions.add(trans);
        System.out.println("Market: transaction enregistrée");
    }

    public void afficherAssets() {
        System.out.println("===== Liste des Assets =====");

        if (assets.isEmpty()) {
            System.out.println("Aucun asset disponible ❌");
            return;
        }

        for (Asset a : assets) {
            System.out.println(
                    "Code: " + a.getCode() +
                            " | Nom: " + a.getNom() +
                            " | Type: " + a.getType() +
                            " | Prix: " + a.getPrix()
            );
        }
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
