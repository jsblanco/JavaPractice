
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price > 0.0 ? price : 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price > 0.0 ? price : 0;
        this.quantityStock = quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) this.price = price;
    }

    public void adjustStock(int quantityStock) {
        int newQuantity = this.quantityStock + quantityStock;
        if (newQuantity >= 0) this.quantityStock = newQuantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) return true;

        if ((obj == null) || (obj.getClass() != this.getClass())) return false;

        return this.name.equals(((StockItem) obj).getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if (o == this) return 0;
        if (o != null) return this.name.compareTo(o.getName());
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price + "€";
    }
}
