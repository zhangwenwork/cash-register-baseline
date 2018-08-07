package cashregister;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

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

    @Test
    void should_print_this_with_mockito() {
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("Purchase as string");

        Printer printer = mock(Printer.class);

        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        verify(printer, times(1)).print("Purchase as string");
    }
}
