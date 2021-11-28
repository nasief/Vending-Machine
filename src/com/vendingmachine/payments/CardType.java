package com.vendingmachine.payments;

public enum CardType implements PaymentType {
    VISA(0),
    MASTER_CARD(0);

    private int cents;

    CardType(int cents) {
        this.cents = cents;
    }

    @Override
    public int centify() {
        return this.cents;
    }

}
