public class Renew extends Customer {

  private String customerName;

  Renew(String customerName) {
    super('B');
    this.customerName = customerName;
  }

  @Override
  String getCustomerInfo() {
    return (
      "Renewal License. Ticket Number: " +
      getTicketNumber() +
      ". Name: " +
      customerName
    );
  }
}
