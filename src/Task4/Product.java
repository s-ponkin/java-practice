package Task4;

public class Product implements Comparable {

    private String name;
    private int cost;
    private double amount;

    public Product(String name, int cost, double amount) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
    }

    public void add(int cost) {
        this.cost += cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + " - " + cost + " шт. - " + amount + " р.";
    }

    @Override
    public int compareTo(Object o) {
        Product product = (Product) o;
        int res = Integer.compare(this.cost, product.getCost());
        return res;
    }
}
