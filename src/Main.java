import java.util.Scanner;

public  class Main {
    private static Scanner input = new Scanner(System.in);
    static Market market = new Market();

    public static int admin() {
        int choix = 0;
        do {
            try {
                System.out.println("=========Mode Admin ========== \n" +
                        "| 1 - Ajouter un Trader                   |\n" +
                        "| 2 - Ajouter un Asset                    |\n" +
                        "| 3 - Mettre à jour les prix (Random)     |\n" +
                        "| 4 - Quitte                              |\n" +
                        "|_________________________________________|");
                System.out.println("choisi--->");
                choix = input.nextInt();
                switch (choix) {
                    case 1: market.ajouterTrader(); break;
                    case 2: market.ajouterAsset();break;
                    case 3: market.UpdatePrixAsset(); break;
                }
            } catch (Exception e) {
                System.out.println("Erreur");
            }
        } while (choix != 4);
        return choix;
    }



    public  static int trader () {
        int choose = 0;
        do {
            try {
                System.out.println("===== Mode Trader =====");
                System.out.println("1. Acheter un Asset");
                System.out.println("2. Vendre un Asset");
                System.out.println("3. Afficher Portfolio d'un Trader");
                System.out.println("4. Afficher Transactions");
                System.out.println("5. Afficher tous les Assets");
                System.out.println("6. Quitter");
                System.out.print("Votre choix: ");
                System.out.println("choisi--->");
                choose = input.nextInt();

                switch (choose) {
                    case 1: market.acheter();
                        break;

                    case 2:
                        market.vendre();
                        break;

                    case 3:
                        market.afficherPortfolioTrader();
                        break;

                    case 4:
                        market.afficherTransactions();
                        break;

                    case 5:
                        market.afficherAssets();
                        break;

                    case 6:
                        System.out.println("Au revoir 👋");
                        break;

                    default:
                        System.out.println("Choix invalide");
                }
            } catch (Exception e) {
                System.out.println("Error: la chaîne de caractères n'est pas un nombre valide.");
            }
        } while (choose != 6);

    return choose;
    }


    public static void main(String[] args) {


            int choisi = 0;

            do {
                System.out.println("======== MENU PRINCIPAL =======");
                System.out.println("|_________| XTrader |_________|\n" +
                        "| 1 - Admin mode             |\n" +
                        "| 2 - Client mode            |\n" +
                        "| 3 - Quitte                 |\n" +
                        "|____________________________|");
                System.out.println("choisi--->");
                choisi = input.nextInt();
                switch (choisi) {
                    case 1:
                        admin();
                        break;
                    case 2:
                        trader();
                        break;
                    case 3:
                        System.out.println("quittez programme");
                        break;
                }


            }while (choisi != 3) ;


        }
    }





