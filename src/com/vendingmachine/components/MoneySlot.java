package com.vendingmachine.components;

import com.vendingmachine.payments.PaymentMethod;

public interface MoneySlot<T extends PaymentMethod> {

    int validateInserted(T money);

}
