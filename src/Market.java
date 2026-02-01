import java.util.*;
import java.util.Random;
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
        String code= sc.nextLine();
        System.out.println("Entrer Nom :");
        String nom=sc.nextLine();
        System.out.println("Entrer le prix :");
        double prix = sc.nextDouble();

        Asset actif;
        if(typeAsset==1){
            actif=new Stock(code,nom,prix);
        } else {
            actif=new CryptoCurrency(code,nom,prix);
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

    private Trader choisirTrader() {
        if (traders.isEmpty()) {
            System.out.println("Aucun treder disponible !!");
            return null;
        }
        for (int i = 0; i < traders.size(); i++) {
            System.out.println(i + " " + traders.get(i).getNom());
        }

        System.out.println("choisi trader :");
        int index = sc.nextInt();
        sc.nextLine();

        if (index<0||index>traders.size()){
            System.out.println("index invalide");
            return null;
        }

        return traders.get(index);
    }

    private Asset choisirAsset(){
        if (assets.isEmpty()){
            System.out.println("Aucun Asset disponible");
            return null;
        }
        for(int i=0;i<assets.size();i++){
            System.out.println(i+" "+assets.get(i).getNom());
        }
        System.out.println("choisi Asset :");
        int index=sc.nextInt();

        if (index<0||index>assets.size()){
            System.out.println("index invalide");
            return null;
        }

        return assets.get(index);
    }

    public  void acheter(){
        Trader trader =choisirTrader();
        if (trader==null)return;
        Asset actif=choisirAsset();
        if (actif==null)return;

        System.out.println("Market: demande d'achat");

        System.out.println("Quantité :");
        double quantite= sc.nextDouble();
        trader.acheterAsset(actif,quantite);

        Transaction trans =new Transaction("Achat",actif,quantite,new Date());
        transactions.add(trans);
        System.out.println("Market: transaction enregistrée");

    }

    public void vendre(){
        System.out.println("Market: demande de vendre");

        Trader trader =choisirTrader();
        if (trader==null)return;
        Asset actif=choisirAsset();
        if (actif==null)return;

        System.out.println("Quantite :");
        double quantite = sc.nextDouble();
        trader.venteAsset(actif,quantite);

        Transaction trans =new Transaction("Vente",actif,quantite,new Date());
        transactions.add(trans);
        System.out.println("Market: transaction enregistrée");
    }

    //utiliser Random
    public void UpdatePrixAsset(){

        Asset actif=choisirAsset();
        if (assets.isEmpty()) {
            System.out.println("Aucun asset a mise a jour !!");
            return;
        }

        Random random=new Random();
        System.out.println("====Mise à jour Random====");
         for(Asset a:assets){

             double acPrix= a.getPrix();
              double valeur =(random.nextDouble()*0.2)-0.1;// -10% à +10%
              double nvPrix= acPrix+(acPrix*valeur);
              if (nvPrix<1){
                  nvPrix=1;
              }
              a.setPrix(nvPrix);
             System.out.println(a.getNom() + " "+acPrix +nvPrix);

         }
    }

    public void afficherAssets() {
        System.out.println("===== Liste des Assets =====");

        if (assets.isEmpty()) {
            System.out.println("Aucun asset disponible ");
            return;
        }

        for (Asset a : assets) {
            System.out.println("Code: " + a.getCode() +" Nom: " + a.getNom() + " Type: " + a.getType() + " Prix: " + a.getPrix()
            );
        }
    }

    public void afficherPortfolioTrader(){
        Trader trader =choisirTrader();
        if (trader==null)return;
       Portfolio portfolio =new Portfolio<>();
       portfolio.afficherProtflio();
    }

    public void afficherTransactions(){
        if(transactions.isEmpty()){
            System.out.println("Aucun transaction");
            return;
        }

        System.out.println("===== Historique des Transactions =====");
        for (Transaction t :transactions){
            System.out.println(t.getType()+"-"+t.getActif().getNom()+"-"+t.getQuantite()+"-"+t.getDate());
        }
    }
}
