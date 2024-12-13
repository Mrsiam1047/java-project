import java.util.ArrayList;

public class Order {
    private Customer customer;
    private ArrayList<MenuItem> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order for: " + customer.getName() + "\nItems:\n");
        for (MenuItem item : items) {
            orderDetails.append(item).append("\n");
        }
        orderDetails.append("Total: $" + calculateTotal());
        return orderDetails.toString();
    }
}
