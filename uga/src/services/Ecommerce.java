package services;

import entities.*;

import java.util.List;
import java.util.Scanner;

public class Ecommerce {
    private UserInterface user;
    private Cart cart;
    private Scanner scanner;
    private List<Processor> processors;
    private List<Memory> memories;
    private List<GraphicsCard> graphicsCards;

    public Ecommerce() {
        this.user = null;
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
        initializeProducts();
    }

    private void initializeProducts() {
        Supplier galax = new Supplier("Galax");
        Supplier asus = new Supplier("Asus");
        Supplier gigabyte = new Supplier("Gigabyte");

        // Adicionando processadores
        processors = List.of(
            new Processor("Intel Core i5", 199.99, galax),
            new Processor("AMD Ryzen 7", 299.99, asus),
            new Processor("Intel Core i9", 499.99, gigabyte)
            // Adicione mais processadores, se necessário
        );

        // Adicionando memórias
        memories = List.of(
            new Memory("8GB DDR4 RAM", 79.99, galax),
            new Memory("16GB DDR4 RAM", 129.99, asus),
            new Memory("32GB DDR4 RAM", 249.99, gigabyte)
            // Adicione mais memórias, se necessário
        );

        // Adicionando placas de vídeo
        graphicsCards = List.of(
            new GraphicsCard("NVIDIA GTX 1660", 299.99, galax),
            new GraphicsCard("AMD Radeon RX 5700", 449.99, asus),
            new GraphicsCard("NVIDIA RTX 3080", 699.99, gigabyte)
            // Adicione mais placas de vídeo, se necessário
        );
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
                    continue;
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
                            manageCart();
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
        System.out.println("Select a category:");
        System.out.println("1. Processor");
        System.out.println("2. Memory");
        System.out.println("3. Graphics Card");
        System.out.print("Enter your choice: ");
        int categoryChoice = scanner.nextInt();

        List<? extends Product> products;
        switch (categoryChoice) {
            case 1:
                products = processors;
                break;
            case 2:
                products = memories;
                break;
            case 3:
                products = graphicsCards;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        // Display products in the chosen category
        System.out.println("Available products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }

        // Select a product to add to the cart
        System.out.print("Enter the number of the product to add to the cart: ");
        int productChoice = scanner.nextInt();

        if (productChoice >= 1 && productChoice <= products.size()) {
            cart.addItem(products.get(productChoice - 1));
            System.out.println("Product added to the cart.");
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private void manageCart() {
        while (true) {
            int cartStatus = cart.showCart();
            if (cartStatus == 0) {
                // Carrinho vazio, retorna para o menu do cliente
                return;
            }
    
            int cartOption = scanner.nextInt();
            switch (cartOption) {
                case 1:
                    // Go to checkout
                    // Implemente a lógica de pagamento aqui
                    break;
                case 2:
                    // Remove item
                    System.out.print("Enter the item number to remove: ");
                    int itemIndex = scanner.nextInt();
                    cart.removeItem(itemIndex - 1);
                    break;
                case 3:
                    // Return to the main menu (Customer menu)
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Ecommerce ecommerce = new Ecommerce();
        ecommerce.run();
    }
}
