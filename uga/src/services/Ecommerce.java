package services;

import entities.Customer;
import entities.UserInterface;

import java.util.Scanner;

public class Ecommerce {
    private UserInterface user;
    private Cart cart;
    private Scanner scanner;

    public Ecommerce() {
        this.user = null;
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Welcome to E-commerce!");
            System.out.println("1. Login");
            System.out.println("2. Create an account");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                user = new Customer("", "", scanner);

                    user.login();
                    break;
                case 2:
                user = new Customer("", "", scanner);

                    user.createAccount();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            if (user != null) {
                while (true) {
                    System.out.println("1. Add item");
                    System.out.println("2. Cart");
                    System.out.println("3. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            addItemsToCart();
                            break;
                        case 2:
                            cart.showCart();
                            break;
                        case 3:
                            System.out.println("Exiting the system. Goodbye!");
                            System.exit(0);
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                }
            }
        }
    }

    private void addItemsToCart() {
        // Implement logic to add items to the cart here
    }
}
