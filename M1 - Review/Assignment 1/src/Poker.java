import java.util.ArrayList;
import java.util.Arrays;

public class Poker {

  private PlayingCards deck;
  ArrayList<String> hand1 = new ArrayList<String>();
  ArrayList<String> hand2 = new ArrayList<String>();

  Poker() {
    deck = new PlayingCards();
    deck.Shuffle();
    dealHands();
  }

  Poker(ArrayList<String> hand1, ArrayList<String> hand2) {
    deck = new PlayingCards();
    this.hand1 = hand1;
    this.hand2 = hand2;
  }

  public void dealHands() {
    for (int i = 0; i < 5; i++) {
      hand1.add(deck.getNextCard());
      hand2.add(deck.getNextCard());
    }
  }

  public void showHand(int deckNumber) {
    if (deckNumber == 1) {
      System.out.println("Player 1’s hand:”");
      System.out.println(String.join(",", hand1));
    }
    if (deckNumber == 2) {
      System.out.println("Player 2’s hand:”");
      System.out.println(String.join(",", hand2));
    }
    System.out.println("");
  }

  public int[] countSuite(ArrayList<String> hand) {
    int[] suiteArr = { 0, 0, 0, 0 };
    for (int i = 0; i < hand.size(); i++) {
      String card = hand.get(i);
      if (card.contains("Clubs")) suiteArr[0] = ++suiteArr[0];
      if (card.contains("Diamonds")) suiteArr[1] = ++suiteArr[1];
      if (card.contains("Hearts")) suiteArr[2] = ++suiteArr[2];
      if (card.contains("Spades")) suiteArr[3] = ++suiteArr[3];
    }
    return suiteArr;
  }

  public int[] countValues(ArrayList<String> hand) {
    int[] valueArr = new int[13];
    for (int i = 0; i < hand.size(); i++) {
      String card = hand.get(i);
      if (card.contains("A")) valueArr[0] = ++valueArr[0];
      for (int r = 2; r < 11; r++) {
        if (card.contains(Integer.toString(r))) valueArr[r - 1] =
          ++valueArr[r - 1];
      }

      if (card.contains("J")) valueArr[10] = ++valueArr[10];
      if (card.contains("Q")) valueArr[11] = ++valueArr[11];
      if (card.contains("K")) valueArr[12] = ++valueArr[12];
    }
    return valueArr;
  }

  public int numParis(int[] countedValues) {
    int pairCount = 0;
    for (int i = 0; i < countedValues.length; i++) {
      if (countedValues[i] == 2) {
        pairCount++;
      }
    }
    return pairCount;
  }

  public static int findIndex(int arr[], int t) {
    int index = Arrays.binarySearch(arr, t);
    return (index < 0) ? -1 : index;
  }

  public boolean threeOfAKind(int[] countedValues) {
    // function needs to return a boolean not int
    // as an int it is possible for the first index, 0, to be a 3, this would result in a bug if there is a hand with 3 A's
    for (int i = 0; i < countedValues.length; i++) {
      if (countedValues[i] == 3) {
        return true;
      }
    }
    return false;
  }

  public boolean fourOfAKind(int[] countedValues) {
    // function needs to return a boolean not int
    // as an int it is possible for the first index, 0, to be a 3, this would result in a bug if there is a hand with 4 A's
    for (int i = 0; i < countedValues.length; i++) {
      if (countedValues[i] == 4) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouse(int[] countedValues) {
    boolean isFullHouse = false;

    if (
      threeOfAKind(countedValues) && numParis(countedValues) == 1
    ) isFullHouse = true;
    return isFullHouse;
  }

  public boolean straight(int[] countedValues) {
    boolean isStraight = false;
    int count = 0;
    for (int i = 0; i < 13; i++) {
      if (countedValues[i] == 1) {
        count = count + 1;
      } else count = 0;
      if (count == 5) isStraight = true;
    }
    if (
      countedValues[0] == 1 &&
      countedValues[9] == 1 &&
      countedValues[10] == 1 &&
      countedValues[11] == 1 &&
      countedValues[12] == 1
    ) isStraight = true;
    return isStraight;
  }

  public boolean flush(int[] countedSuite) {
    boolean isFlush = false;

    for (int i = 0; i < 4; i++) {
      if (countedSuite[i] == 5) isFlush = true;
    }
    return isFlush;
  }

  public boolean straightFlush(int[] countedSuite, int[] countedValues) {
    boolean isStraightFlush = false;
    if (straight(countedValues) && flush(countedSuite)) isStraightFlush = true;
    return isStraightFlush;
  }

  public boolean royalFlush(int[] countedSuite, int[] countedValues) {
    boolean isRoyalFlush = false;
    if (
      flush(countedSuite) &&
      (
        countedValues[0] == 1 &&
        countedValues[9] == 1 &&
        countedValues[10] == 1 &&
        countedValues[11] == 1 &&
        countedValues[12] == 1
      )
    ) isRoyalFlush = true;
    return isRoyalFlush;
  }

  public String getStrengthOfHand(ArrayList<String> hand) {
    int[] countedSuites = new int[4];
    countedSuites = countSuite(hand);
    int[] countedValues = new int[13];
    countedValues = countValues(hand);

    if (royalFlush(countedSuites, countedValues)) return "Royal Flush";
    if (straightFlush(countedSuites, countedValues)) return "Straight Flush";
    if (fourOfAKind(countedValues)) return "Four Of A Kind";
    if (fullHouse(countedValues)) return "Full House";
    if (flush(countedSuites)) return "Flush";
    if (straight(countedValues)) return "Straight";
    if (threeOfAKind(countedValues)) return "Three Of A Kind";
    if (numParis(countedValues) == 2) return "Two Pair";
    if (numParis(countedValues) == 1) return "One Pair";
    return "High Card";
  }

  public String scoreHand(int handInt) {
    if (handInt == 1) {
      return getStrengthOfHand(hand1);
    } else {
      return getStrengthOfHand(hand2);
    }
  }
}
