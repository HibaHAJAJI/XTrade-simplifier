import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Market market = new Market();

        int choix;

        do {
            System.out.println("1. Ajouter un Asset");
            System.out.println("2. Ajouter un Trader");
            System.out.println("3. Acheter un Asset");
            System.out.println("4. Vendre un Asset");
            System.out.println("5. Afficher Portfolio");
            System.out.println("6. Afficher Transactions");
            System.out.println("0. Quitter");


            choix = sc.nextInt();

            switch (choix) {

                case 1:

                    break;

                case 2:

                    break;

                case 3:
                    break;

                case 4:
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
