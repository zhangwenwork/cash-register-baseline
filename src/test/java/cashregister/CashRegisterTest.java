package cashregister;


import org.junit.jupiter.api.Test;

class CashRegisterTest {
    @Test
    void should_print_the_real_purchase() {
        Item[] items = new Item[]{
                new Item("Item 1", 30),
                new Item("Item 2", 40),
        };
        Purchase purchase = new Purchase(items);

        MockPrinter printer = new MockPrinter();
        CashRegister cashRegister = new CashRegister(printer);
        cashRegister.process(purchase);

        printer.verifyThatPrintWasCalledWith("Item 1\t30.0\n" +
                "Item 2\t40.0\n");
    }

    @Test
    void should_print_this_with_stub_purchase() {
        Purchase purchase = new StubPurchase("Purchase as string");
        MockPrinter printer = new MockPrinter();

        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        printer.verifyThatPrintWasCalledWith("Purchase as string");
    }
}
