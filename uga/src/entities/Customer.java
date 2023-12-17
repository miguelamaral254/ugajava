package entities;

import java.util.Scanner;

public class Customer extends Account implements UserInterface {
    private Scanner scanner; // Adicionado scanner como variável de membro

    public Customer(String name, String password, Scanner scanner) {
        super(name, password);
        this.scanner = scanner;
    }

    @Override
    public void login() {
        boolean loggedIn = false;

        do {
            System.out.print("Enter your name: ");
            String nameInput = scanner.next();
            System.out.print("Enter your password: ");
            String passwordInput = scanner.next();

            if (nameInput.equals(getName()) && passwordInput.equals(getPassword())) {
                System.out.println("Login successful.");
                loggedIn = true;
                showLoggedInMenu();
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        } while (!loggedIn);
    }

    @Override
    public void createAccount() {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        super.setName(name);
        super.setPassword(password);
        System.out.println("Account created successfully.");

        // Retorna diretamente ao menu principal (tela inicial)
        showMainMenu();
    }

    private void showLoggedInMenu() {
        System.out.println("Welcome, " + getName() + "!");
     
    }

    @Override
    public void showMainMenu() {
        System.out.println("Welcome to E-commerce!");
        System.out.println("1. Login");
        System.out.println("2. Create an account");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                login();
                break;
            case 2:
                createAccount();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}
