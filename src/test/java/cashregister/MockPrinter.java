package cashregister;

import static org.assertj.core.api.Assertions.assertThat;

public class MockPrinter extends Printer {
    private boolean printWasCalled = false;
    private String printWasCalledWith = null;

    @Override
    public void print(String printThis) {
        printWasCalledWith = printThis;
        printWasCalled = true;
    }

    public void verifyThatPrintWasCalled() {
        assertThat(printWasCalled)
                .as("expected print to be called at least once, print was not called")
                .isTrue();
    }

    public void verifyThatPrintWasCalledWith(String printThis) {
        verifyThatPrintWasCalled();
        assertThat(printWasCalledWith)
                .as("expected print to be called with '" + printThis + "', but was called with '")
                .isEqualTo(printThis);
    }
}