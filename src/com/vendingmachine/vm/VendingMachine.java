package com.vendingmachine.vm;

import com.vendingmachine.components.*;
import com.vendingmachine.items.Item;
import com.vendingmachine.payments.*;

import java.util.*;

public abstract class VendingMachine {

    private KeyBad keyBad;
    private Map<Integer, Item> items;
    private int insertedMoney;
    private SlotType selectedSlot;
    private MoneySlot inputSlot;
    private Item selectedItem;

    public VendingMachine() {
        this.keyBad = new KeyBad();
        this.items = new HashMap<>();
    }

    public KeyBad getKeyBad() {
        return this.keyBad;
    }

    public Item selectItem() {
        int pressedKey = this.keyBad.getPressed();
        Item candidateItem = items.get(pressedKey);
        if (isItemAvailable(pressedKey)) {
            selectedItem = candidateItem;
            System.out.println("Selected Item Price " + selectedItem.getPrice());
            return candidateItem;
        } else {
            System.out.println("Item Not available. Please Select another one");
            return null;
        }
    }

    public boolean tryDispenseItem(Item selectedItem) {
        if (selectedItem.getPrice() <= insertedMoney) {
            selectedItem.setAvailable(selectedItem.getAvailable() - 1);
            return true;
        } else {
            System.out.println("Not enough money inserted.");
            return false;
        }
    }

    private int calculateChangeInCents() {
        return this.insertedMoney - this.selectedItem.getPrice();
    }

    public void acceptPayment(PaymentMethod method) {
        this.inputSlot = MoneySlotFactory.create(getSelectedSlot());
        if (inputSlot != null) {
            int acceptedAmount = inputSlot.validateInserted(method);
            if (acceptedAmount == -1) {
                System.out.println("Unacceptable Payment");
            } else {
                insertedMoney += acceptedAmount;
                System.out.println("Amount So Far " + insertedMoney);
            }
        }
    }

    public boolean isItemAvailable(int itemNumber) {
        return items.get(itemNumber).getAvailable() > 0;
    }

    public void fill(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            this.items.put(i + 1, items.get(i));
        }
    }

    public Map<PaymentType, Integer> calculateChange() {
        Map<PaymentType, Integer> changeMap = new HashMap<>();

        int totalChange = calculateChangeInCents();
        System.out.println("Total Change " + totalChange);
        int count = totalChange / (50 * 100);

        if (count != 0) {
            changeMap.put(NoteType._50D, count);
            totalChange -= count * 50 * 100;
        }

        count = totalChange / (20 * 100);
        if (count != 0) {
            changeMap.put(NoteType._20D, count);
            totalChange -= count * 20 * 100;
        }

        count = totalChange / 100;
        if (count != 0) {
            changeMap.put(CoinType._1D, count);
            totalChange -= count * 100;
        }

        count = totalChange / 50;
        if (count != 0) {
            changeMap.put(CoinType._50C, count);
            totalChange -= count * 50;
        }

        count = totalChange / 20;
        if (count != 0) {
            changeMap.put(CoinType._20C, count);
            totalChange -= count * 20;
        }

        count = totalChange / 10;
        if (count != 0) {
            changeMap.put(CoinType._10C, count);
        }

        return changeMap;
    }

    public SlotType getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(SlotType selectedSlot) {
        this.selectedSlot = selectedSlot;
    }
}
