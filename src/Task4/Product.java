package Task4;

public class Product implements Comparable {

    private String name;
    private int amount;
    private double cost;

    public Product(String name, int amount, double cost) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
    }

    public void add(int amount) {
        this.amount += amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name + " - " + amount + " шт. - " + cost + " р.";
    }

    @Override
    public int compareTo(Object o) {
        Product product = (Product) o;
        return Integer.compare(this.amount, product.getAmount());
    }
}
