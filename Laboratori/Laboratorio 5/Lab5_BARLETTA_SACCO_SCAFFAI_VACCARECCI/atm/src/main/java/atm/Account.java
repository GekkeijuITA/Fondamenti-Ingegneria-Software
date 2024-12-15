package atm;

public class Account 
{

   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private Euro availableBalance; // funds available for withdrawal
   private Euro totalBalance; // funds available + pending deposits

   public Account(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = new Euro(theAvailableBalance);
      totalBalance = new Euro(theTotalBalance);
   } 

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN(int userPIN) {
      return (userPIN == pin);
   } 
   
   // returns available balance
   public Euro getAvailableBalance() {
      return availableBalance;
   } 

   // returns the total balance
   public Euro getTotalBalance() {
      return totalBalance;
   }

   // credits an amount to the account
   public void credit(double amount) {
      totalBalance.sum(new Euro(amount));
   } 

   // debits an amount from the account
   public void debit(double amount) {
      availableBalance.subtract(new Euro(amount));
      totalBalance.subtract(new Euro(amount));
   } 

   // returns account number
   public int getAccountNumber() {
      return accountNumber;  
   }

} 