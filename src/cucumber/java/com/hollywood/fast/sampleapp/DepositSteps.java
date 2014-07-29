package com.hollywood.fast.sampleapp;


import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DepositSteps {
  
  private Account account;
  
  @Given("^a User has no money in their account$")
  public void a_User_has_no_money_in_their_account() {
    User user = new User();
    account = new Account();
    user.setAccount(account);
    Assert.assertTrue("The balance is not zero.", account.getBalance() == 0);
  }

  @When("^£(\\d+) is deposited in to the account$")
  public void £_is_deposited_in_to_the_account(int amount) {
     account.deposit(amount);
  }

  @Then("^the balance should be £(\\d+)$")
  public void the_balance_should_be_£(int balance) {
    Assert.assertTrue("The balance is not zero.", account.getBalance() == balance);
  }

  private class User {
    private Account account;

    public void setAccount(Account account) {
      this.account = account;
    }
  }

  private class Account {
    private int balance;

    public Account() {
      this.balance = 0;
    }

    public int getBalance() {
      return balance;
    }

    public void deposit(int amount) {
      this.balance += amount;
    }
  }


}
