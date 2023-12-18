package entities;

import java.util.Scanner;

public class Admin extends Account implements UserInterface {
    private Scanner scanner;

    public Admin(String name, String password, Scanner scanner) {
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
        System.out.println("Creating an ADMIN account is not supported. Please contact the system administrator.");
    }

    private void showLoggedInMenu() {
        System.out.println("Welcome, " + getName() + "!");
        System.out.println("ADMIN MENU:");
        System.out.println("1. Dashboard de vendas");
        System.out.println("2. Gerenciar funcionários");
        System.out.println("3. Logout");

        int option = scanner.nextInt();
        handleAdminMenu(option);
    }

    private void handleAdminMenu(int option) {
        switch (option) {
            case 1:
                // Implemente a lógica para o Dashboard de vendas
                System.out.println("Dashboard de vendas");
                break;
            case 2:
                // Implemente a lógica para Gerenciar funcionários
                System.out.println("Gerenciar funcionários");
                break;
            case 3:
                System.out.println("Logging out. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                showLoggedInMenu();
        }
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
