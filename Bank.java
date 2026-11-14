import java.util.ArrayList;
import java.io.*;

public class Bank implements HasMenu{

  private Admin admin;
  private CustomerList customers;

  // main
  public static void main(String[] args){
    Bank bank = new Bank();
    bank.start();
    bank.saveCustomers();
  } // end main

  // Bank
  public Bank(){
    admin = new Admin();
    customers = new CustomerList();
    loadCustomers();
  } // end Bank

  // loadSampleCustomers
  public void loadSampleCustomers(){
    Customer alice = new Customer("Alice", "0000");
    alice.getCheckingAccount().setBalance(1000.00);
    alice.getSavingsAccount().setBalance(1000.00);

    customers.add(alice);
  } // end loadSampleCustomers

  // menu
  public String menu(){
    System.out.println("\nbank menu");
    System.out.println("_______________\n");
    System.out.println("0) exit system");
    System.out.println("1) login as admin");
    System.out.println("2) login as customer");
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
          System.out.println("login successful!");
          startAdmin();
        }
        else{
          System.out.println("login failed!");
        }
      }

      else if (choice.equals("2")){
        loginAsCustomer();
      }

      else if (!choice.equals("0")){
        System.out.println("invalid! please choose 0-2!");
      }
    }

    System.out.println("exiting bank system...");
  } // end start

  // startAdmin
  public void startAdmin(){
    String choice = "";

    while (!choice.equals("0")){
      choice = admin.menu();

      if (choice.equals("1")){
        fullCustomerReport();
      }
      else if (choice.equals("2")){
        addUser();
      }
      else if (choice.equals("3")){
        applyInterest();
      }
      else if (!choice.equals("0")){
        System.out.println("invalid! please choose 0-3!");
      }
    }
  } // end startAdmin

  // loginAsCustomer
  public void loginAsCustomer(){
    System.out.print("user name: ");
    String userName = User.input.next();

    System.out.print("PIN: ");
    String PIN = User.input.next();

    Customer currentCustomer = null;

    for (Customer customer : customers){
      if (customer.login(userName, PIN)){
        currentCustomer = customer;
        break;
      }
    }

    if (currentCustomer != null){
      System.out.println("login successful!");
      currentCustomer.start();
    }
    else{
      System.out.println("customer login failed!");
    }
  } // end loginAsCustomer

  // fullCustomerReport
  public void fullCustomerReport(){
    System.out.println("\nfull customer report");

    for (Customer customer : customers){
      System.out.println(customer.getReport());
    }
  } // end fullCustomerReport

  // addUser
  public void addUser(){
    System.out.println("\nadd User");

    System.out.print("name: ");
    String userName = User.input.next();

    System.out.print("PIN: ");
    String PIN = User.input.next();

    Customer customer = new Customer(userName, PIN);
    customers.add(customer);

    System.out.println("user successfully added!");
  } // end addUser

  // applyInterest
  public void applyInterest(){
    System.out.println("\napply interest");

    for (Customer customer : customers){
      customer.getSavingsAccount().calcInterest();

      System.out.println("new balance: "
        + customer.getSavingsAccount().getBalanceString());
    }
  } // end applyInterest
  
  // saveCustomers
  public void saveCustomers(){
    try{
      ObjectOutputStream output = new ObjectOutputStream(
        new FileOutputStream("customers.ser"));

      output.writeObject(customers);
      output.close();

      System.out.println("customer data saved!");
    }
    catch (IOException e){
      System.out.println("error saving customer data: " + e.getMessage());
    }
  } // end saveCustomers

  // loadCustomers
  public void loadCustomers(){
    try{
      ObjectInputStream input = new ObjectInputStream(
        new FileInputStream("customers.ser"));

      customers = (CustomerList) input.readObject();
      input.close();

      System.out.println("customer data loaded!");
    }

    catch (FileNotFoundException e){
      System.out.println("no saved customer data found. loading sample customers...");
      loadSampleCustomers();
    }

    catch (IOException | ClassNotFoundException e){
      System.out.println("error loading customer data: " + e.getMessage());
    }
  } // end loadCustomers 

} // end Bank

