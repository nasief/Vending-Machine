package com.vendingmachine.components;

import com.vendingmachine.payments.Coin;
import com.vendingmachine.payments.CoinType;

public class CoinSlot implements MoneySlot<Coin> {

    @Override
    public int validateInserted(Coin coin) {
        return coin.getType() == CoinType._1D || coin.getType() == CoinType._10C || coin.getType() == CoinType._50C
                || coin.getType() == CoinType._20C ? coin.getType().centify() : -1;
    }
}
