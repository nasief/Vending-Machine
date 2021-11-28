package com.vendingmachine.payments;

public abstract class PaymentMethod<T extends PaymentType> {

    private T type;

    public T getType() {
        return this.type;
    }

    public void setType(T type) {
        this.type = type;
    }

}
