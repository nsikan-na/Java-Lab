import java.io.*;
import java.net.*;
import java.util.*;

class PersonNotFound extends Exception {}

public class Main {

  public static float getDollarPrice(ArrayList<String> lines) {
    boolean header = true;
    String json = "";
    for (String line : lines) {
      if (line.equals("")) {
        header = false;
        continue;
      }
      if (header == false) {
        json = line;
        break;
      }
    }
    // System.out.println("JSON: " + json);
    String[] jsonParts = json.split(":");
    String priceLine = jsonParts[19];
    String justPrice = priceLine.replace("},\"GBP\"", "");
    float price = Float.parseFloat(justPrice);
    return price;
  }

  public static ArrayList<String> getData() {
    ArrayList<String> arrList = new ArrayList<>();
    try {
      String dataLine = "";
      Socket mySocket = new Socket("api.coindesk.com", 80);
      OutputStream os = mySocket.getOutputStream();
      PrintWriter pw = new PrintWriter(os);

      pw.println("GET /v1/bpi/currentprice.json HTTP/1.0");
      pw.println("Host: api.coindesk.com");
      pw.println();
      pw.flush();

      Scanner scan = new Scanner(mySocket.getInputStream());
      while (scan.hasNextLine()) {
        dataLine = scan.nextLine();
        arrList.add(dataLine);
      }

      mySocket.close();
      scan.close();
    } catch (IOException err) {
      System.out.println(err);
    }
    return arrList;
  }

  public static void buyBitCoin(float bitcoinPrice) {
    try {
      File initialInvestmentUSDFile = new File("initialInvestmentUSD.txt");
      Scanner scan = new Scanner(initialInvestmentUSDFile);
      String dataLine = "";
      File myFile = new File("clientBC.txt");
      PrintWriter pw = new PrintWriter(myFile);

      while (scan.hasNextLine()) {
        dataLine = scan.nextLine();
        String[] data = dataLine.split(":");
        String name = data[0];
        float dollars = Float.parseFloat(data[1]);
        float bitcoin = dollars / bitcoinPrice;
        pw.println(name + ":" + bitcoin);
      }
      scan.close();
      pw.close();
    } catch (Exception err) {
      System.out.println(err);
    }
  }

  public static void getCurrentValue(float bitcoinValue) {
    try {
      File file = new File("clientBC.txt");
      Scanner scan = new Scanner(file);
      String dataLine = "";
      while (scan.hasNextLine()) {
        dataLine = scan.nextLine();
        String[] data = dataLine.split(":");
        String name = data[0];
        float numOfBitcoin = Float.parseFloat(data[1]);
        System.out.println(name + ":$" + numOfBitcoin * bitcoinValue);
      }
      scan.close();
    } catch (Exception err) {
      System.out.println(err);
    }
  }

  public static float getPersonFromFile(String personName, String fileName)
    throws PersonNotFound {
    float price = 0;
    try {
      File file = new File(fileName);
      Scanner scan = new Scanner(file);
      String dataLine = "";
      String data = "";
      while (scan.hasNextLine()) {
        dataLine = scan.nextLine();
        data += dataLine;
        if (dataLine.contains(personName)) {
          break;
        }
      }
      if (!data.contains(personName)) {
        scan.close();
        throw new PersonNotFound();
      }
      price = Float.parseFloat(dataLine.split(":")[1]);
      scan.close();
    } catch (Exception err) {
      System.out.println(err);
    }
    return price;
  }

  public static void main(String[] args) {
    try {
      Scanner scan = new Scanner(System.in);
      int num;
      do {
        System.out.println(
          "One Bitcoin is currently worth $" + getDollarPrice(getData())
        );
        System.out.println("1. Buy Bitcoin");
        System.out.println("2. See everyone's current value in USD");
        System.out.println("3. See one person's gain/loss");
        System.out.println("4. Quit");
        num = Integer.parseInt(scan.nextLine());
        switch (num) {
          case 1:
            {
              float bitcoinPrice = getDollarPrice(getData());
              System.out.println("Bitcoin price: $" + bitcoinPrice);
              buyBitCoin(bitcoinPrice);
              break;
            }
          case 2:
            {
              float bitcoinValue = getDollarPrice(getData());
              System.out.println("Bitcoin value: $" + bitcoinValue);
              getCurrentValue(bitcoinValue);
              break;
            }
          case 3:
            {
              System.out.println("Please enter a name");
              String name = scan.nextLine();
              float numOfBitcoin = getPersonFromFile(name, "clientBC.txt");
              float originalInvestment = getPersonFromFile(
                name,
                "initialInvestmentUSD.txt"
              );
              float currentPrice = getDollarPrice(getData());
              float currentValue = numOfBitcoin * currentPrice;
              System.out.println(name + ":");
              System.out.println("Original Investment: $" + originalInvestment);
              System.out.println("Number of bitcoins: " + numOfBitcoin);
              System.out.println("Current Value: $" + currentValue);
              System.out.println(
                "Change in value: $" + (currentValue - originalInvestment)
              );
              break;
            }
          case 4:
            {
              break;
            }
        }
      } while (num != 4);
      scan.close();
    } catch (Exception err) {
      System.out.println(err);
    }
  }
}
