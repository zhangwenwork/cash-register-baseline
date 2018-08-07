package cashregister;

import static org.assertj.core.api.Assertions.assertThat;

public class MockPrinter extends Printer {
    private String printWasCalledWith;
    private boolean printWasCalled;

    @Override
    public void print(String printThis) {
        printWasCalledWith = printThis;
        printWasCalled = true;
    }

    public void verifyThatPrintWasCalledWith(String printThis){
        assertThat(printWasCalled)
                .as("Printer should be called in mock printer")
                .isTrue();

        assertThat(printThis)
                .as("Should meet the parameters enter")
                .isEqualTo(printWasCalledWith);
    }
}
