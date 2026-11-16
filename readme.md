```mermaid
classDiagram
  class HasMenu {
    <<interface>>
    +menu() String
    +start() void
  }

  class CheckingAccount {
    <<Serializable>>
    -balance double
    -input Scanner$
    +CheckingAccount()
    +CheckingAccount(balance)
    +main(args) void$
    +menu() String
    +start() void
    +getBalance() double
    +getBalanceString() String
    +setBalance(balance) void
    +checkBalance() void
    -getDouble() double
    +makeDeposit() void
    +makeWithdrawal() void
  }

  class SavingsAccount {
    -interestRate double
    +main(args) void$
    +calcInterest() void
    +setInterestRate(interestRate) void
    +getInterestRate() double
  }

  class User {
    <<abstract>>
    <<Serializable>>
    -userName String
    -PIN String
    #input Scanner$
    +login() boolean
    +login(userName, PIN) boolean
    +setUserName(userName) void
    +getUserName() String
    +setPIN(PIN) void
    +getPIN() String
    +getReport() String*
  }

  class Admin {
    +Admin()
    +menu() String
    +start() void
    +getReport() String
  }

  class Customer {
    -checking CheckingAccount
    -savings SavingsAccount
    +main(args) void$
    +Customer()
    +Customer(userName, PIN)
    +start() void
    +startCustomerMenu() void
    +menu() String
    +changePin() void
    +getCheckingAccount() CheckingAccount
    +getSavingsAccount() SavingsAccount
    +getReport() String
  }

  class CustomerList {
    <<ArrayList~Customer~>>
  }

  class Bank {
    -admin Admin
    -customers CustomerList
    +main(args) void$
    +Bank()
    +loadSampleCustomers() void
    +menu() String
    +start() void
    +startAdmin() void
    +loginAsCustomer() void
    +fullCustomerReport() void
    +addUser() void
    +applyInterest() void
    +saveCustomers() void
    +loadCustomers() void
  }

  CheckingAccount ..|> HasMenu : Implements
  User ..|> HasMenu : Implements

  SavingsAccount --|> CheckingAccount : Extends
  Admin --|> User : Extends
  Customer --|> User : Extends
  CustomerList --|> ArrayList : Extends

  Bank "1" o-- "1" Admin : admin
  Bank "1" o-- "1" CustomerList : customers
  CustomerList "1" o-- "0..*" Customer : stores
```
# Serialization in Bank.java
```
// saveCustomers()
initialize saveCustomers{
  try{
    create serialization file for storing customer information

    retrieve customer list from bank

    save list into serialization file

    close file

    print confirmation message that the data was saved
  }

  catch{
    print error message saying customer data could not be saved
  }
} // end saveCustomers

// loadCustomers
initialize loadCustomers{
  try{
    open the created serialization file

    retrieve the customer data list stored inside file

    replace current customer list with list from file

    close file

    print confirmation message saying customer data was loaded
  }

  catch{
    print error message saying no saved customer data was found

    load the sample customers
  }

  catch{
    print error message saying customer data could not be loaded
  }
} // end loadCustomers
```
