public class NewTest extends Customer {

  private String customerName;
  private String dateOfBirth;

  NewTest(String customerName, String dateOfBirth) {
    super('A');
    this.customerName = customerName;
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  String getCustomerInfo() {
    return (
      "New Drivers License. Ticket Number: " +
      getTicketNumber() +
      " Name: " +
      customerName +
      " DOB: " +
      dateOfBirth
    );
  }
}
