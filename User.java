import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable{

  private String userName;
  private String PIN;
  protected static Scanner input = new Scanner(System.in);

  // login
  public boolean login(){
    System.out.print("user name: ");
    String enteredUserName = input.next();

    System.out.print("PIN: ");
    String enteredPIN = input.next();

    return login(enteredUserName, enteredPIN);
  } // end login

  // login + parameters
  public boolean login(String userName, String PIN){
    return this.userName.equals(userName) && this.PIN.equals(PIN);
  } // end login

  // setUserName
  public void setUserName(String userName){
    this.userName = userName;
  } // end setUserName

  // getUserName
  public String getUserName(){
    return userName;
  } // end getUserName

  // setPIN
  public void setPIN(String PIN){
    this.PIN = PIN;
  } // end setPIN

  // getPIN
  public String getPIN(){
    return PIN;
  } // end getPIN

  public abstract String getReport();

} // end User

