package services;

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
                
                System.out.println("Acessando Dashboard de vendas...");
                break;
            case 2:

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

        
        String adminUsername = "admin";
        String adminPassword = "admin";

        
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
