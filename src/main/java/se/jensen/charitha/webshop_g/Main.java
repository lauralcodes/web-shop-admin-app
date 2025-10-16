package se.jensen.charitha.webshop_g;

import se.jensen.charitha.webshop_g.model.Dairy;
import se.jensen.charitha.webshop_g.model.Meat;
import se.jensen.charitha.webshop_g.model.Product;
import se.jensen.charitha.webshop_g.model.Vegan;

import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in); // Locate out side of the main method; To use both in the main method and other methods
    private static ProductCatalogue catalogue = new ProductCatalogue();

    public static void main(String[] args) {
        startAdminPage();
    }

    private static void startAdminPage() {
        printMenu();

        System.out.println(" Enter the number you want to select: ");
        String menuSelection = scanner.nextLine();

        switch (menuSelection) {
            case "1":
                System.out.println(" you chose to add a new product");
                handleAddNewProduct();

                startAdminPage();
                break;

            case "2":
                System.out.println(" You chose to display the product list");
                catalogue.listAllProducts();
                System.out.println("\n");
                startAdminPage();
                break;

            case "3":
                System.out.println("You chose to display the information of a product");
                handleDisplayInfo();
                startAdminPage();
                break;

            case "4":
                System.out.println("You are exiting the application");
                scanner.close();
                break;

            default:
                System.out.println("Invalid input");
                startAdminPage();
        }
    }

    private static void printMenu() {
        System.out.println("*** PICK & GO - ADMIN PAGE MENU ***");
        System.out.println(" 1 - Add Product ");
        System.out.println(" 2 - List all products ");
        System.out.println(" 3 - Show info about a product ");
        System.out.println(" 4 - Exit the application ");
        System.out.println("\n");
    }

    private static void handleAddNewProduct() {
        System.out.println("\n");

        String category = setCategory();
        
        System.out.println("Enter follwing details of the product");
        System.out.println("Article number: ");
        String articleNumber = scanner.nextLine();

        System.out.println("Name/Title of the product: ");
        String title = scanner.nextLine();

        System.out.println("Price in SEK: ");
        double priceValue = 0;
        while (true) {
            String price = scanner.nextLine();
            try {
                priceValue = Double.parseDouble(price);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter the price again");
            }
        }
        System.out.println("Product description: ");
        String description = scanner.nextLine();

         switch (category) {
             case "1" -> {
                 Vegan v1 = new Vegan(articleNumber, title, priceValue, description);
                 catalogue.addProduct(v1);
                 System.out.println("*** " + title + " is added to the catalogue ***");
             }
             case "2" -> {
                 Dairy d1 = new Dairy(articleNumber, title, priceValue, description);
                 catalogue.addProduct(d1);
                 System.out.println("*** " + title + " is added to the catalogue ***");
             }
             case "3" -> {
                 Meat m1 = new Meat(articleNumber, title, priceValue, description);
                 catalogue.addProduct(m1);
                 System.out.println("*** " + title + " is added to the catalogue ***");
             }
             default -> System.out.println("Invalid input");
         }

        System.out.println("\n");

    }

    private static String setCategory() {
        System.out.println(" --- Choose the category for your product ---");
        String selectedCategory;

        while (true) {
            System.out.println(" 1 - Vegan ");
            System.out.println(" 2 - Dairy ");
            System.out.println(" 3 - Meat ");

            System.out.println(" Enter the number you want to select: ");
            selectedCategory = scanner.nextLine();
            if (selectedCategory.equals("1") || selectedCategory.equals("2") || selectedCategory.equals("3")) {
                break;

            } else {
                System.out.println(" Invalid input. Please select the category again");
            }
        }
        return selectedCategory;

    }

    private static void handleDisplayInfo() {
        System.out.println("Enter the Article Number of the product: ");
        String givenArticleNumber = scanner.nextLine();

        try {
            Product product = catalogue.searchProduct(givenArticleNumber);

            System.out.println("Product name:" + product.getTitle() + ", Article Number:" + product.getArticleNumber() + ", Price:" + product.getPrice() + ", Description:" + product.getDescription());

        } catch (NullPointerException e) {
            System.out.println("Product with given article number is not found");
        }

        System.out.println("\n");
    }
}
