package com.vendingmachine.components;

public class MoneySlotFactory {

    public static MoneySlot create(SlotType slotType) {
        switch (slotType) {
            case CARD:
                return new CardSlot();
            case COIN:
                return new CoinSlot();
            case NOTE:
                return new NoteSlot();
            default:
                return null;
        }
    }

}
