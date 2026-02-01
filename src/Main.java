import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Market market = new Market();

        int choix=0;

        do {
            try{
                System.out.println("\n===== MENU PRINCIPAL =====");
                System.out.println("1. Ajouter un Trader");
                System.out.println("2. Ajouter un Asset");
                System.out.println("3. Acheter un Asset");
                System.out.println("4. Vendre un Asset");
                System.out.println("5. Mettre à jour les prix (Random)");
                System.out.println("6. Afficher Portfolio d'un Trader");
                System.out.println("7. Afficher Transactions");
                System.out.println("8. Afficher tous les Assets");
                System.out.println("9. Quitter");
                System.out.print("Votre choix: ");


            choix = sc.nextInt();

            switch (choix) {

                case 1: market.ajouterTrader(); break;

                case 2: market.ajouterAsset();break;

                case 3: market.acheter(); break;

                case 4: market.vendre();  break;

                case 5: market.UpdatePrixAsset(); break;

                case 6:
                    market.afficherPortfolioTrader();
                    break;

                case 7: market.afficherTransactions();break;

                case 8: market.afficherAssets();break;

                case 9: System.out.println("Au revoir 👋");break;

                default: System.out.println("Choix invalide");
            }
                }catch (Exception e){
                   System.out.println("Error: la chaîne de caractères n'est pas un nombre valide.");

               }
        } while (choix != 9);

        sc.close();
    }
}
