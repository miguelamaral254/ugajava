package services;

import entities.*;

import java.util.Scanner;

public class AdminService {
    private Scanner scanner;

    public AdminService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runAdminMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Dashboard de vendas");
        System.out.println("2. Gerenciar funcionários");
        System.out.println("3. Logout");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Lógica para o Dashboard de vendas
                System.out.println("Acessando Dashboard de vendas...");
                break;
            case 2:
                // Lógica para gerenciar funcionários
                System.out.println("Acessando Gerenciamento de funcionários...");
                break;
            case 3:
                System.out.println("Logout realizado.");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminService(scanner);

        // Usuário admin predefinido
        String adminUsername = "admin";
        String adminPassword = "admin";

        // Login do admin
        System.out.print("Enter admin username: ");
        String usernameInput = scanner.next();
        System.out.print("Enter admin password: ");
        String passwordInput = scanner.next();

        if (adminUsername.equals(usernameInput) && adminPassword.equals(passwordInput)) {
            System.out.println("Admin login successful.");
            adminService.runAdminMenu();
        } else {
            System.out.println("Invalid admin credentials. Exiting.");
        }
    }
}
