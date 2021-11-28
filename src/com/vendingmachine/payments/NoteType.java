package com.vendingmachine.payments;

public enum NoteType implements PaymentType {
    _20D(20 * 100, "$50"),
    _50D(50 * 100, "@20");

    private int cents;
    private String name;

    NoteType(int cents, String name) {
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
