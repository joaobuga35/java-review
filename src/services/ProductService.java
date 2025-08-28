package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import entities.Product;

public class ProductService {

    private HashMap<Integer, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void getProducts() {
        for (Integer key : products.keySet()) {
            Product product = products.get(key);
            System.out.println("ID: " + key + " - Object: " + product);
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

    public Product searchById(int id) {
        Product product = products.get(id);
        if (product != null) {
            System.out.println("Product found: " + product);
            return product;
        } else {
            System.out.println("No product found with ID: " + id);
            throw new RuntimeException("Product not found");
        }
    }

    public void searchByName(String name) {
        List<Product> results = products.values().stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        if (results.isEmpty()) {
            System.out.println("Nenhum produto encontrado!");
        } else {
            results.forEach(System.out::println);
        }

    }

    public void removeProduct(int id) {
        if (products.containsKey(id)) {
            products.remove(id);
            System.out.println("Product with ID " + id + " removed.");
        } else {
            System.out.println("No product found with ID: " + id);
            throw new RuntimeException("Product not found");
        }
    }

    // Alternative implementation USING List

    // public List<Product> searchByName(String name) {
    // List<Product> results = products.stream()
    // .filter(product ->
    // product.getName().toLowerCase().contains(name.toLowerCase()))
    // .collect(Collectors.toList());

    // if (results.isEmpty()) {
    // throw new RuntimeException("No products found with name: " + name);
    // }

    // System.out.println(results);
    // return results;
    // }

    // public Product searchById(int id) {
    // Optional<Product> productOpt = products.stream()
    // .filter(product -> product.getId() == id)
    // .findFirst();

    // if (productOpt.isPresent()) {
    // return productOpt.get();
    // } else {
    // throw new RuntimeException("Product not found");
    // }
    // }

}
