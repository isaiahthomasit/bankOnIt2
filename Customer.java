public class Customer extends User{

  private CheckingAccount checking;
  private SavingsAccount savings;

  // main
  public static void main(String[] args){
    Customer customer = new Customer();
    customer.start();
  }

  // Customer
  public Customer(){
    this("Alice", "0000");
  }

  public Customer(String userName, String PIN){
    setUserName(userName);
    setPIN(PIN);

    checking = new CheckingAccount();
    savings = new SavingsAccount();
  } // end Customer

  // start
  public void start(){
    if (login()){
      System.out.println("login successful");

      String choice = "";

      while (!choice.equals("0")){
        choice = menu();

        if (choice.equals("1")){
          System.out.println("checking Account");
          checking.start();
        }
        else if (choice.equals("2")){
          System.out.println("savings Account");
          savings.start();
        }
        else if (choice.equals("3")){
          changePin();
        }
        else if (!choice.equals("0")){
          System.out.println("invalid! please choose 0-3!");
        }
      }
    }

    else{
      System.out.println("login failed");
    }

  } // end start

  // menu
  public String menu(){
    System.out.println("\ncustomer menu");
    System.out.println("_______________\n");
    System.out.println("0) exit");
    System.out.println("1) manage checking account");
    System.out.println("2) manage savings account");
    System.out.println("3) change PIN\n");
    System.out.print("please choose 0-3: ");

    return input.next();
  } // end menu

  // changePin
  public void changePin(){
    System.out.print("enter new PIN: ");
    String newPIN = input.next();

    setPIN(newPIN);

    System.out.println("PIN successfully changed!");
  } // end changePin

  // getCheckingAccount
  public CheckingAccount getCheckingAccount(){
    return checking;
  } // end getCheckingAccount

  // getSavingsAccount
  public SavingsAccount getSavingsAccount(){
    return savings;
  } // getSavingsAccount

  // getReport
  public String getReport(){
    return "Customer: " + getUserName()
      + "\nchecking balance: " + checking.getBalanceString()
      + "\nsavings balance: " + savings.getBalanceString();
  } // end getReport

} // end Customer

