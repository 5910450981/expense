package csku.spender;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepDefSpender {

    SpenderEnroll spenders;

    @Before
    public void init(){
        spenders = new SpenderEnroll(15000);
    }

    @Given("a person have balance (\\d+) exists")
    public void a_person_have_balance_exists(int balance){
        spenders = new SpenderEnroll(balance);
    }

    @When("I get salary (\\d+) from my jobs")
    public void i_get_salary_from_my_jobs(int income){
        spenders.add(income);
    }

    @When("I spend rent (\\d+) for my car")
    public void i_spend_rent_for_my_car(int expense){
        spenders.add(expense);
    }

    @Given("I have balance is (\\d+)")
    public void i_have_balance_is(int balance){
        spenders.getBalance();
    }

}
