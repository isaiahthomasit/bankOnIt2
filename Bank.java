import java.util.ArrayList;

public class Bank implements HasMenu{

  private Admin admin;
  private ArrayList<Customer> customers;

  // main
  public static void main(String[] args){
    Bank bank = new Bank();
    bank.start();
  } // end main

  // Bank
  public Bank(){
    admin = new Admin();
    customers = new ArrayList<Customer>();
  } // end Bank

  // menu
  public String menu(){
    System.out.println("\nbank menu");
    System.out.println("_______________\n");
    System.out.println("0) exit system");
    System.out.println("1) login as admin");
    System.out.println("2) login as customer\n");
    System.out.print("\nplease choose 0-2: ");

    return User.input.next();
  } // end menu

  // start
  public void start(){
    String choice = "";

    while (!choice.equals("0")){
      choice = menu();

      if (choice.equals("1")){
        System.out.println("\nadmin login");

        if (admin.login()){
          System.out.println("admin login successful!");
          System.out.println("admin menu");
        }
        else{
          System.out.println("admin login failed!");
        }
      }

      else if (choice.equals("2")){
        System.out.println("customer login");
      }

      else if (!choice.equals("0")){
        System.out.println("invalid! please choose 0-2!");
      }
    }

    System.out.println("exiting bank system...");
  } // end start

} // end Bank

