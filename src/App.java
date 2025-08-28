
import java.util.Scanner;

import entities.Product;
import services.ProductService;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        int option = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Search using name");
            System.out.println("4. Search using the ID");
            System.out.println("5. Change the quantity of a product");
            System.out.println("6. Change the price of a product");
            System.out.println("7. Exit");
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
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    productService.searchByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter product ID to search: ");
                    int idNumber = scanner.nextInt();
                    productService.searchById(idNumber);
                    break;
                case 5:
                    System.out.print("Enter product ID to change quantity: ");
                    int idForQuantity = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    productService.changeQuantity(idForQuantity, newQuantity);
                    System.out.println("Product quantity updated successfully!");
                    break;
                case 6:
                    System.out.print("Enter product ID to change price: ");
                    int idForPrice = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    productService.changePrice(idForPrice, newPrice);
                    System.out.println("Product price updated successfully!");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 7);

    }
}
