public class Move extends Customer {

  private String customerName;
  private String state;

  Move(String customerName, String state) {
    super('C');
    this.customerName = customerName;
    this.state = state;
  }

  @Override
  String getCustomerInfo() {
    return (
      "Moved from " +
      state +
      ". Ticket Number: " +
      getTicketNumber() +
      ". Name: " +
      customerName
    );
  }
}
