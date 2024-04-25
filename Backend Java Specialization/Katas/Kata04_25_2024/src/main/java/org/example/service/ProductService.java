package org.example.service;

public interface ProductService {

    void addProduct(String name, double price);

    void listProducts();

    void searchProductByName(String nameToSearch);
}
