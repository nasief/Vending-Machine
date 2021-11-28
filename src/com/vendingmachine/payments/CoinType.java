package com.vendingmachine.payments;

public enum CoinType implements PaymentType {
    _50C(50, "¢50"),
    _20C(20, "¢0"),
    _1D(100, "$1"),
    _10C(10, "¢10");

    private int cents;
    private String name;

    CoinType(int cents, String name) {
        this.cents = cents;
        this.name = name;
    }

    @Override
    public int centify() {
        return this.cents;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
