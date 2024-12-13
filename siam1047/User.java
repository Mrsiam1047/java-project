import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static ArrayList<User> users = new ArrayList<>();
    private String username;
    private String password;
    private String role;  // "customer" or "employee"

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter role (customer/employee): ");
        String role = sc.nextLine();

        users.add(new User(username, password, role));
        System.out.println("Registration successful!");
    }

    public static boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String getRole() {
        return role;
    }
}
