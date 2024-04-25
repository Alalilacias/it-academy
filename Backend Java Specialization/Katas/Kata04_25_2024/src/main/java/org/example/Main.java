package org.example;

import org.example.menu.InventoryMenu;
import org.example.service.ProductService;
import org.example.service.impl.ProductServiceImpl;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        InventoryMenu inventoryMenu = new InventoryMenu(productService);
        inventoryMenu.run();
    }
}