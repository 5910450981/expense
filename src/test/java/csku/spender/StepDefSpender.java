package csku.spender;

import csku.model.SpenderModel;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.ArrayList;

public class StepDefSpender {

    SpenderModel spenders;

    @Before
    public void init(){
        spenders = new SpenderModel();
    }

    @Given("a person have balance (\\d+) exists")
    public void a_person_have_balance_exists(double balance){
        spenders.getBalance();
    }

    @When("I get salary (\\d+) from my jobs")
    public void i_get_salary_from_my_jobs(double amount){
        spenders.addSpender("Salary", amount, "2018-10-16");
    }

    @When("I spend food (\\d+) from store")
    public void i_spend_rent_from_store(double amount){
        spenders.addSpender("Food", (amount *= -1), "2018-10-16");
    }

    @When("I edit salary (\\d+) to (\\d+)")
    public void i_edit_salary_to(double amount, double replace){
        ArrayList<Spender> spenderList = spenders.getSpender();

        spenders.editSpender(spenderList.get(0),
                "Salary", replace, "2018-10-16");
    }

    @Given("I have balance is (\\d+)")
    public void i_have_balance_is(int balance){
        spenders.getBalance();
    }



}
