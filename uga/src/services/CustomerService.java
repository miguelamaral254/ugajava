
package services;

import entities.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private List<Customer> existingCustomers;
    private Scanner scanner;

    public CustomerService(Scanner scanner) {
        this.existingCustomers = new ArrayList<>();
        this.scanner = scanner;
    }

    public void runCustomerMenu() {
        System.out.println("Customer Menu:");
        System.out.println("1. View Profile");
        System.out.println("2. Update Profile");
        System.out.println("3. View Purchase History");
        System.out.println("4. Return");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                viewProfile();
                break;
            case 2:
                updateProfile();
                break;
            case 3:
                viewPurchaseHistory();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void viewProfile() {
        
        System.out.println("Viewing customer profile.");
    }

    private void updateProfile() {
        
        System.out.println("Updating customer profile.");
    }

    private void viewPurchaseHistory() {
        
        System.out.println("Viewing purchase history.");
    }
}
