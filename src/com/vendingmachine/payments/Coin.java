package com.vendingmachine.payments;

public class Coin extends PaymentMethod<CoinType> {

    public Coin(CoinType coinType) {
        setType(coinType);
    }

}
