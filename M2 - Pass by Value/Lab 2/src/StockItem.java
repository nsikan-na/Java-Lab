public class StockItem {

  private String description;
  private int id;
  private static int nextId = 1;
  private double price;
  private int quantity;

  public String getDescription() {
    return description;
  }

  public int getId() {
    return id;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setPrice(double newPrice) {
    if (newPrice < 0) {
      System.out.println("Price can not be less than 0");
    } else price = newPrice;
  }

  public void lowerQuantity(int lowerByQuantity) {
    int newQuantity = quantity - lowerByQuantity;
    if (newQuantity < 0) {
      System.out.println("Price can not be less than 0");
    } else quantity = newQuantity;
  }

  public void raiseQuantity(int raiseByQuantity) {
    quantity = quantity + raiseByQuantity;
  }

  public StockItem() {
    description = "";
    price = 0.00;
    quantity = 0;
    this.id = nextId;
    nextId++;
  }

  public StockItem(String description, double price, int quantity) {
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.id = nextId;
    nextId++;
  }

  @Override
  public String toString() {
    return (
      "Item number: " +
      id +
      "\nDescription: " +
      description +
      "\nPrice: " +
      price +
      "\nQuantity: " +
      quantity
    );
  }
}
