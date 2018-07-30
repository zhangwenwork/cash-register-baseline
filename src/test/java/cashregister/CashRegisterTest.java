package cashregister;


import org.junit.jupiter.api.Test;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase() {
        //initialize CashRegister and fake Printer

        cashRegister.process(purchase);

        //verify that printer was called
    }
}
