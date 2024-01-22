import java.util.Scanner;

public class RestaurantOrderSystem {

    // Menu
    static String[][] menu = {
            {"Schnitzel", "7"},
            {"Pommes", "3"},
            {"Kartoffel-Gratain", "8"},
            {"Lasagne", "12"},
            {"Wasser", "1.50"},
            {"Cola", "2.50"},
            {"Pizza Margherita", "10"},
            {"Chicken Wings", "6"},
            {"Gemüsepfanne", "9"},
            {"Tiramisu", "5.50"},
            {"Eistee", "2.20"},
            {"Burger", "8.50"},
            {"Spaghetti Bolognese", "11"},
            {"Salat Nicoise", "7.50"},
            {"Schokoladenkuchen", "4"},
            {"Cappuccino", "3.80"},
            {"Burrito", "9.50"},
            {"Fruchtsalat", "5"},
            {"Hotdog", "4.50"},
            {"Mango-Lassi", "2.80"}
    };

    String order;

    public static void main(String[] args) {
        RestaurantOrderSystem orderSystem = new RestaurantOrderSystem();
        orderSystem.menuOutput(menu);
    }

    void menuOutput(String[][] inputMenu) {
        System.out.println("********************************************");
        System.out.println("-------------------|Menu|-------------------");
        System.out.println("********************************************");
        System.out.println();

        for (int i = 0; i < inputMenu.length; i++) {
            System.out.printf("%-30s %.2fEUR%n", inputMenu[i][0], Double.parseDouble(inputMenu[i][1]));
        }
    }


    void bestellen(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ihre Bestellung (nur ein Gerricht/Getränk): ");
        order = scan.next();
    }
}
