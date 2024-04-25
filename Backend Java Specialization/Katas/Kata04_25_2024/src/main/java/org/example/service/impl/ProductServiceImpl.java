package org.example.service.impl;

import org.example.exception.InventoryEmptyException;
import org.example.exception.ProductNotFoundException;
import org.example.model.Product;
import org.example.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static final List<Product> inventory = new ArrayList<>();

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        inventory.add(product);
    }

    public void listProducts() {
        if (inventory.isEmpty()) {
            throw new InventoryEmptyException("The inventory is empty.");
        }
        System.out.println("Inventory:");
        inventory.forEach(System.out::println);
    }

    public void searchProductByName(String nameToSearch) {
        Product product = inventory.stream()
                .filter(p -> p.getName().equalsIgnoreCase(nameToSearch))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + nameToSearch));
        System.out.println("Product found: " + product);
    }
}
