package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Product searchByName(String name) {
        List<Product> productNames = products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if (!productNames.isEmpty()) {
            return productNames.get(0);
        }
        return null;
    }

}
