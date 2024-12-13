import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<MenuItem> menu = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample menu items
        menu.add(new MenuItem("Burger", 5.99));
        menu.add(new MenuItem("Pizza", 8.99));
        menu.add(new MenuItem("Pasta", 6.99));
        menu.add(new MenuItem("Salad", 4.99));

        // Main Menu Loop
        while (true) {
            System.out.println("\n---- Restaurant Management System ----");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            if (option == 1) {
                // Login
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                if (User.loginUser(username, password)) {
                    System.out.println("Login successful!");
                    showMainMenu(sc);
                } else {
                    System.out.println("Invalid login credentials.");
                }
            } else if (option == 2) {
                // Register
                User.registerUser();
            } else if (option == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void showMainMenu(Scanner sc) {
        while (true) {
            System.out.println("\n---- Main Menu ----");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Logout");
            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            if (option == 1) {
                // View Menu
                System.out.println("---- Menu ----");
                for (MenuItem item : menu) {
                    System.out.println(item);
                }
            } else if (option == 2) {
                // Place Order
                System.out.print("Enter customer name: ");
                String customerName = sc.nextLine();
                System.out.print("Enter customer contact: ");
                String contactInfo = sc.nextLine();

                Customer customer = new Customer(customerName, contactInfo);
                customers.add(customer);

                Order order = new Order(customer);
                while (true) {
                    System.out.println("Select an item to order (Enter 0 to finish): ");
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.get(i).getName() + " - $" + menu.get(i).getPrice());
                    }
                    int itemChoice = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    if (itemChoice == 0) break;
                    if (itemChoice > 0 && itemChoice <= menu.size()) {
                        order.addItem(menu.get(itemChoice - 1));
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
                orders.add(order);
                System.out.println("Order placed successfully:\n" + order);
            } else if (option == 3) {
                // View Orders
                System.out.println("---- Orders ----");
                for (Order order : orders) {
                    System.out.println(order);
                }
            } else if (option == 4) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}

