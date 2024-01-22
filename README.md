## **Overview:**
ATM GUI that allows users to list accounts, deposit money, and
withdraw money, based on the Bank system.

# ***Funtionalities of ATM:***
ATM GUI consists of the following Funtionalities:
- Withdraws Money from *Chequing* and *Saving account*.
- Deposites Money in *Chequing* and *Saving account*.
- Saves user's data for future use using *File Management*.

<div align="center">
  <img src="https://github.com/ah03-khurram/ATM-GUI-COMP2001/assets/155772948/bc8bb45f-6cb2-4657-9a31-9fa18ed11ec7" width="1000"/>
  <span style="color:red;">ATM GUI</span>
</div>

## *Overview*:
***Bank*** maintains two types of accounts for each customer: ***savings***, and ***chequing***. The savings account provides
compound interest and withdrawal facility, while the chequing account offers a cheque book facility but no
interest.

# ***Account class:***
- ## **Methods**:
  - ### **Account()**:
    - The default constructor that generates an account number using a random integer and initializes other member variables.
  - ### **Account(String user)**:
    - The overloaded constructor that takes the argument for the account name and initializes other member variables.
  - ### **void display()**:
    - Displays (print) the account information.
  - ### **void deposit(float m)**:
    - Accepts a deposit from a customer and updates the balance.
  - ### **withdraw(float m)**:
    - Defines an abstract method that can be overridden by the derived class and enables late dynamic calling of corresponding member functions in the derived classes
  - ### **float getBalance()**:
    - returns the balance.
  - ### **String getUserName()**:
    - returns the user name.

---

## **Two derived classes from the Account class**:
*Cheque* and *Saving*. In the Cheque class, private
static final member variables minimBalance and overLimitCharge (set to 1000 and 5, respectively). In the
Saving class, a private static final member variable called eachTimeCharge (set to 3.9) stores the
service rate for each time a withdrawal is made.

# ***Cheque class:***
The Cheque class have the following member functions:
- Two constructors similar to those of the parent class Account.
- A withdraw function that withdraws money according to the user's request. This function, checks if this
withdrawal is allowed according to the available balance and withdraw limit for each time. Calculates the over-limit service fee if the balance is lower than a limit when applying a withdrawal. Updates the balance.

# ***Saving  class:***
The Saving class have the following member functions:
- Two constructors similar to those of the parent class Account.
- A withdraw function that withdraws money according to the user's request. This function, checks if this withdrawal is allowed according to the available balance for each time. Applies a service fee for each time a withdrawal is made. Updates the balance.

---

# ***Bank class:***
## *Overview*:
Bank class maintains the accounts, which has members bankName and an ArrayList accounts that
store chequing and saving accounts. The Bank class have the following member functions:

- ## **Methods**:
  - ### **Bank()**:
    - The default constructor that creates a new empty account list (using ArrayList).
  - ### **Bank(String name)**:
    - A constructor with a string argument for the bank name.
  - ### **void add(Account a)**:
    - Adds the account (either Saving or Cheque objects).
  - ### **void display()**:
    - Displays the bank name and the full list of accounts (including the user’s name, balance, and the type of account (whether it is Saving or not)).
  - ### **display(String user)**:
    - Displays the bank name and the list of accounts of a specific user name (including the user’s name, balance, and the type of account (whether it is Saving or not)).
