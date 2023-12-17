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
        System.out.print("Enter your name: ");
        String nameInput = scanner.next();
        System.out.print("Enter your password: ");
        String passwordInput = scanner.next();

        if (nameInput.equals(getName()) && passwordInput.equals(getPassword())) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid credentials. Please try again.");
            login();
        }
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
    }
}
