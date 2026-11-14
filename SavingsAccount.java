public class SavingsAccount extends CheckingAccount{

  private double interestRate = 0.05;

  // testing
  public static void main(String[] args){
    SavingsAccount account = new SavingsAccount();
    account.start();
  }

  // calcInterest
  public void calcInterest(){
    double interest = getBalance() * interestRate;
    setBalance(getBalance() + interest);

    System.out.println("interest applied: " + String.format("$%.2f", interest));
    System.out.println("new balance: " + getBalanceString());
  } // end calcInterest

  // setInterestRate
  public void setInterestRate(double interestRate){
    this.interestRate = interestRate;
  } // end setInterestRate

  // getInterestRate
  public double getInterestRate(){
    return interestRate;
  } // end getInterestRate

} // end SavingsAccount

