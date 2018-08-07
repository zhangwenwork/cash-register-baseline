package cashregister;

class StubPurchase extends Purchase {
    private String purchaseAsString;

    StubPurchase(String purchaseAsString) {
        super(null);

        this.purchaseAsString = purchaseAsString;
    }

    @Override
    public String asString() {
        return purchaseAsString;
    }
}
