package services;

import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    public int showCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return 0;  // Retorna 0 para indicar que o carrinho está vazio
        } else {
            System.out.println("----------[Items]----------------");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName());
            }
            System.out.println("---------------------------------");
            System.out.println("1 - Go to checkout");
            System.out.println("2 - Remove item");
            System.out.println("3 - Return to the main menu (Customer menu)");
            System.out.print("Choose an option: ");
            return 1;  // Retorna 1 para indicar que o carrinho não está vazio
        }
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            Product removedItem = items.remove(index);
            System.out.println(removedItem.getName() + " removed from the cart.");
        } else {
            System.out.println("Invalid item index. Please try again.");
        }
    }

    public List<Product> getItems() {
        return items;
    }
}
