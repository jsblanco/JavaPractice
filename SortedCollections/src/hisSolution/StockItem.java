package hisSolution;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock = 0;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price > 0.0 ? price : 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price > 0.0 ? price : 0;
        this.quantityInStock = quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) this.price = price;
    }

    public void adjustStock(int quantityStock) {
        int newQuantity = this.quantityInStock + quantityStock;
        if (newQuantity >= 0) this.quantityInStock = newQuantity;
    }

    public int finaliseStock(int quantity) {
        if (quantity <= reserved) {
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock - reserved;
    }

    public int reserveStock(int quantity) {
        if (quantity <= quantityInStock) {
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
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
        if (o == this) return 0;
        if (o != null) return this.name.compareTo(o.getName());
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price + "€. Reserved: "+this.reserved;
    }
}
