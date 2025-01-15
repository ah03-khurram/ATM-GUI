# ATM GUI

## Overview
This project is an ATM GUI that allows users to list accounts, deposit money, and withdraw money, based on the Bank system. The ATM GUI supports both Chequing and Saving accounts and includes file management to save and load user data.

## Features
### ATM Functionalities
- **Withdraw Money**: Allows users to withdraw money from both Chequing and Saving accounts.
- **Deposit Money**: Allows users to deposit money into both Chequing and Saving accounts.
- **File Management**: Saves and loads user data for future use.

### Account Types
- **Chequing Account**: Offers a cheque book facility but no interest. Includes a minimum balance requirement and an over-limit charge.
- **Saving Account**: Provides compound interest and a withdrawal facility. Includes a service fee for each withdrawal.

### Bank Class
- Maintains a list of accounts (both Chequing and Saving) for each customer.
- Displays bank information and account details.

## How to Use the ATM
1. **Run the ATM Application**: Execute the `ATM` class with the user's name as an argument.
   ```sh
   java ATM "User Name"
   ```
2. **ATM Interface**: The ATM GUI will open, displaying the user's accounts.
3. **Menu Options**:
  - **Accounts**:
    - **All Accounts**: Lists all accounts for the user.
    - **Chequing**: Lists only Chequing accounts.
    - **Saving**: Lists only Saving accounts.
  - **File**:
    - **Open**: Opens a saved bank file.
    - **Save**: Saves the current bank data to a file.
  - **Help**:
    - **About**: Displays information about the user and the bank.

## Classes and Methods
### Account Class
  - **Methods**:
    - **Account()**: The default constructor that generates an account number using a random integer and initializes other member variables.
    - **Account(String user)**: The overloaded constructor that takes the argument for the account name and initializes other member variables.
    - **void display()**: Displays (prints) the account information.
    - **void deposit(float m)**: Accepts a deposit from a customer and updates the balance.
    - **void withdraw(float m)**: Withdraws an amount of money from the account.
    - **float getBalance()**: Returns the balance.
    - **String getUsername()**: Returns the username.
    - **int getAccountNo()**: Returns the account number.

### Cheque Class
  - **Methods**:
    - **Cheque()**: Default constructor.
    - **Cheque(String user)**: Constructor with a username argument.
    - **void withdraw(float m)**: Withdraws money according to the user's request, applying over-limit charges if necessary.

### Saving Class
  - **Methods**:
    - **Saving()**: Default constructor.
    - **Saving(String user)**: Constructor with a username argument.
    - **void withdraw(float m)**: Withdraws money according to the user's request, applying a service fee for each withdrawal.

### Bank Class
  - **Methods**:
    - **Bank()**: Default constructor that creates a new empty account list.
    - **Bank(String name)**: Constructor with a string argument for the bank name.
    - **void add(Account a)**: Adds an account (either Saving or Cheque).
    - **void display()**: Displays the bank name and the full list of accounts.
    - **void display(String user)**: Displays the bank name and the list of accounts for a specific user.

### FileManager Class
  - **Methods**:
    - **static Bank read(String filename)**: Reads a bank object from a file.
    - **static void write(String filename, Bank bank)**: Writes a bank object to a file.

## Screenshot
<div align="center"> <img src="https://github.com/ah03-khurram/ATM-GUI-COMP2001/assets/155772948/bc8bb45f-6cb2-4657-9a31-9fa18ed11ec7" width="1000"/> <span style="color:red;">ATM GUI</span> </div>