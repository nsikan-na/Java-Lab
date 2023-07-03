class Lot {

  private int lotNumber;
  private static int lotNumberNext = 1001;
  private String description;
  private int currentBid;
  private int bidIncrement;
  private boolean sold;

  Lot() {
    description = "Unknown Item";
    currentBid = 0;
    bidIncrement = 0;
    sold = false;
    lotNumber = lotNumberNext;
    lotNumberNext++;
  }

  Lot(String description, int currentBid, int bidIncrement) {
    this.description = description;
    this.currentBid = currentBid;
    this.bidIncrement = bidIncrement;
    sold = false;
    lotNumber = lotNumberNext;
    lotNumberNext++;
  }

  public boolean getSold() {
    return sold;
  }

  public int getBidIncrement() {
    return bidIncrement;
  }

  public String getDescription() {
    return description;
  }

  public void markSold() {
    sold = true;
  }

  public void setCurrentBid(int currentBid) {
    this.currentBid = currentBid;
  }

  public int nextBid() {
    return currentBid + bidIncrement;
  }

  @Override
  public String toString() {
    if (sold) {
      return (
        "Lot " +
        lotNumber +
        " . " +
        description +
        " was sold for $" +
        currentBid
      );
    } else {
      return (
        "Lot " +
        lotNumber +
        " . " +
        description +
        " current bid $" +
        currentBid +
        " minimum bid $" +
        nextBid()
      );
    }
  }
}
