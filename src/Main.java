import java.util.ArrayList;
import java.util.Scanner;

import entities.Product;
import services.ProductService;

public class Main {
    public static void Main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        int option = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Search using name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(name, price, quantity);
                    productService.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;
                case 2:
                    productService.getProducts();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 3);

    }
}
