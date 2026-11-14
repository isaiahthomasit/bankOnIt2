public class Admin extends User{

  // Admin
  public Admin(){
    setUserName("admin");
    setPIN("0000");
  } // end Admin

  // menu
  public String menu(){
    System.out.println("\nadmin menu");
    System.out.println("______________\n");
    System.out.println("0) exit this menu");
    System.out.println("1) full customer report");
    System.out.println("2) add user");
    System.out.println("3) apply interest to savings accounts\n");
    System.out.print("\nplease choose 1-3:  ");

    return input.next();
  } // end menu

  // start
  public void start(){

  } // end start

  // getReport
  public String getReport(){
    return "admin: " + getUserName() + ", PIN: " + getPIN();
  } // end getReport

} // end Admin

