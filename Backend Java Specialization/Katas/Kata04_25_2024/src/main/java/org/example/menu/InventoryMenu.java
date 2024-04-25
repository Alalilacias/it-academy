package org.example.menu;

import org.example.exception.InventoryEmptyException;
import org.example.exception.ProductNotFoundException;
import org.example.service.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InventoryMenu {
    private final ProductService productService;

    public InventoryMenu(ProductService productService) {
        this.productService = productService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            printMenuOptions();
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                handleMenuOption(option, scanner);
            }  catch (InputMismatchException e) {
                System.out.println("Invalid option. Please enter a number.");
                scanner.nextLine();
                option = 0;
            } catch (InventoryEmptyException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please add products to the inventory before listing.");
            } catch (ProductNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a product that exists.");
                scanner.nextLine();
            }
        } while (option != 4);
    }

    private void handleMenuOption(int option, Scanner scanner) {
        switch (option) {
            case MenuOption.ADD_PRODUCT -> addProduct(scanner);
            case MenuOption.LIST_PRODUCTS -> productService.listProducts();
            case MenuOption.SEARCH_PRODUCT -> searchProductByName(scanner);
            case MenuOption.EXIT -> System.out.println("Goodbye!");
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void printMenuOptions() {
        System.out.println("1. Add product");
        System.out.println("2. List products");
        System.out.println("3. Search product by name");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    private void addProduct(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();

        double price = 0;
        boolean validPrice = false;
        do {
            try {
                System.out.print("Enter the product price: ");
                price = scanner.nextDouble();
                scanner.nextLine();
                validPrice = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid price.");
                scanner.nextLine();
            }
        } while (!validPrice);
        productService.addProduct(name, price);
        System.out.println("Product added successfully.");
    }

    private void searchProductByName(Scanner scanner) {
        System.out.print("Enter the product name to search: ");
        String nameToSearch = scanner.next();
        productService.searchProductByName(nameToSearch);
    }
}
