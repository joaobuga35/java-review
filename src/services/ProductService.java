package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public void changeQuantity(int id, int newQuantity) {
        Product product = searchById(id);
        product.setQuantity(newQuantity);
    }

    public void changePrice(int id, double newPrice) {
        Product product = searchById(id);
        product.setPrice(newPrice);
    }

    public List<Product> searchByName(String name) {
        List<Product> results = products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            throw new RuntimeException("No products found with name: " + name);
        }
        return results;
    }

    public Product searchById(int id) {
        Optional<Product> productOpt = products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();

        if (productOpt.isPresent()) {
            return productOpt.get();
        } else {
            throw new RuntimeException("Product not found");
        }
    }

}
