import java.util.Scanner;
import java.io.Serializable;

public class CheckingAccount implements HasMenu, Serializable{

  private double balance;
  private static Scanner input = User.input;

  public CheckingAccount(){
    balance = 0.0;
  }

  public CheckingAccount(double balance){
    this.balance = balance;
  }

  // testing
  public static void main(String[] args){
    CheckingAccount account = new CheckingAccount();
    account.start();
  }

  // menu
  public String menu(){
    System.out.println("\naccount menu");
    System.out.println("_______________\n");
    System.out.println("0) quit");
    System.out.println("1) check balance");
    System.out.println("2) make a deposit");
    System.out.println("3) make a withdrawal\n");
    System.out.print("please enter 0-3: ");

    return input.next();
  } // end menu

  // start
  public void start(){
    String choice = "";
  
    while (!choice.equals("0")){
      choice = menu();

      if (choice.equals("1")){
        checkBalance();
      }
    
      else if (choice.equals("2")){
        makeDeposit();
      }

      else if (choice.equals("3")){
        makeWithdrawal();
      }

      else if (!choice.equals("0")){
        System.out.println("invalid! please choose 0-3!");
      }
    }
  } // end start

  public double getBalance(){
    return balance;
  } // end getBalance

  public String getBalanceString(){
    return String.format("$%.2f", balance);
  } // end getBalanceString

  public void setBalance(double balance){
    this.balance = balance;
  } // end setBalance

  public void checkBalance(){
    System.out.println("\nchecking balance...");
    System.out.println("current balance: " + getBalanceString());
  } // end checkBalance

  private double getDouble(){
    return input.nextDouble();
  } // end getDouble

  public void makeDeposit(){
    System.out.println("\nmaking a deposit...");
    System.out.print("how much you want to deposit? ");

    double amount = getDouble();
    balance += amount;

    System.out.println("\nnew balance: " + getBalanceString());
  } // end makeDeposit
 
  public void makeWithdrawal(){
    System.out.println("\nmaking a withdrawal...");
    System.out.print("how much you want to withdraw? ");

    double amount = getDouble();
    balance -= amount;

    System.out.println("\nnew balance: " + getBalanceString());
  } // end makeWithdrawal
 
} // end CheckingAccount

