package services;

import java.util.ArrayList;

import entities.Product;

public class ProductService {

    private ArrayList<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void getProducts() {
        for (Product p : products) {
            System.out.println(
                    "Product Name: " + p.getName() + ", Price: $" + p.getPrice() + ", Quantity: " + p.getQuantity());
        }
    }

}
