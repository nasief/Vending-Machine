package com.vendingmachine.components;

import com.vendingmachine.payments.Card;

public class CardSlot implements MoneySlot<Card> {

    @Override
    public int validateInserted(Card card) {
        // TODO need to add logic that actually validates a card
        return 0;
    }

}
