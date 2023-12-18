package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends Account implements UserInterface {
    private Scanner scanner;
    private static List<Customer> existingCustomers = new ArrayList<>();

    public Customer(String name, String password, Scanner scanner) {
        super(name, password);
        this.scanner = scanner;
    }

    @Override
    public void login() {
        boolean loggedIn = false;

        do {
            System.out.println("---------[LOGIN]----------------");
            System.out.print("Enter your name: ");
            String nameInput = scanner.next();
            System.out.print("Enter your password: ");
            String passwordInput = scanner.next();
            System.out.println("-------------------------");

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

        // Verifica se o usuário já existe
        if (userExists(name)) {
            System.out.println("Username already exists. Please choose a different username.");
            // Retorna diretamente ao menu principal (tela inicial)
            showMainMenu();
            return; // Adiciona esta linha para sair do método e evitar login indevido
        }

        System.out.print("Enter your password: ");
        String password = scanner.next();
        super.setName(name);
        super.setPassword(password);
        System.out.println("Account created successfully.");

        existingCustomers.add(new Customer(name, password, scanner));

        showMainMenu();
    }

    private static boolean userExists(String username) {
        //Account verify
        for (Customer customer : existingCustomers) {
            if (customer.getName().equals(username)) {
                return true; // Usr already taked
            }
        }
        return false; 
    }

    private void showLoggedInMenu() {
        System.out.println("Welcome, " + getName() + "!");
        
    }

    @Override
    public void showMainMenu() {
        System.out.println("-------------------------");
        System.out.println("Welcome to E-commerce!");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Create an account");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        System.out.println("-------------------------");

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
