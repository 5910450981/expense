package csku.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpenderModelTest {

    SpenderModel spender;

    @BeforeEach
    public void initial(){
        spender = new SpenderModel();
    }

    @Test
    public void addIncomeShouldIncreaseBalanceWhenReceivePositive(){
       spender.addSpender("Extra Income", 4500, "2018-10-16");
       assertEquals(7460, spender.getBalance());
    }

    @Test
    public void addExpenseShouldDecreaseBalanceWhenReceiveNegative(){
        spender.addSpender("Gift", -3000, "2018-10-16");
        assertEquals(4460, spender.getBalance());
    }

}