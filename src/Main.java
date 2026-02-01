import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Market market = new Market();

        // Assets TEST
        Asset apple = new Stock(1, "Apple", 150);
        Asset btc = new CryptoCurrency(2, "Bitcoin", 30000);

        market.ajouterAsset(apple);
        market.ajouterAsset(btc);

        // Trader TEST
        Trader trader = new Trader(1, "Hiba", 100000);
        market.ajouterTrader(trader);

        int choix;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Acheter un asset");
            System.out.println("2. Vendre un asset");
            System.out.println("3. Afficher portfolio");
            System.out.println("4. Afficher transactions");
            System.out.println("0. Quitter");
            System.out.print("Votre choix: ");

            choix = sc.nextInt();

            switch (choix) {

                case 1:
                    System.out.println("1. Apple");
                    System.out.println("2. Bitcoin");
                    int a = sc.nextInt();

                    Asset assetAchat = (a == 1) ? apple : btc;

                    System.out.print("Quantité: ");
                    double qAchat = sc.nextDouble();

                    market.acheter(trader, assetAchat, qAchat);
                    break;

                case 2:
                    System.out.println("1. Apple");
                    System.out.println("2. Bitcoin");
                    int v = sc.nextInt();

                    Asset assetVente = (v == 1) ? apple : btc;

                    System.out.print("Quantité: ");
                    double qVente = sc.nextDouble();

                    market.vendre(trader, assetVente, qVente);
                    break;

                case 3:
                    trader.getPortfolio().afficherProtflio();
                    break;

                case 4:
                    market.afficherTransactions();
                    break;

                case 0:
                    System.out.println("Au revoir 👋");
                    break;

                default:
                    System.out.println("Choix invalide");
            }

        } while (choix != 0);

        sc.close();
    }
}
