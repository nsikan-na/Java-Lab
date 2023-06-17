public class Suspended extends Customer {

  private String customerName;
  private String violation;

  Suspended(String customerName, String violation) {
    super('D');
    this.customerName = customerName;
    this.violation = violation;
  }

  @Override
  String getCustomerInfo() {
    return (
      "Violation: " +
      violation +
      ". Ticket Number: " +
      getTicketNumber() +
      ". Name: " +
      customerName
    );
  }
}
