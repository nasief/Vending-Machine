package com.vendingmachine.vm;

import com.vendingmachine.components.SlotType;
import com.vendingmachine.items.Item;
import com.vendingmachine.items.ItemType;
import com.vendingmachine.payments.Coin;
import com.vendingmachine.payments.CoinType;
import com.vendingmachine.payments.PaymentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachineManager {

    private VendingMachine vendingMachine;

    public VendingMachineManager() {
        vendingMachine = new SnackMachine();
        fillMachine();
    }

    private void fillMachine() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Snickers", 150, ItemType.SNACK, 5));
        items.add(new Item("Mars", 120, ItemType.SNACK, 5));
        items.add(new Item("Marshmello", 250, ItemType.SNACK, 5));
        items.add(new Item("KitKat", 130, ItemType.SNACK, 5));
        vendingMachine.fill(items);
    }

    public void buyItem() {
        System.out.println("Please Enter Money");
        // Read Money from Slots
        vendingMachine.setSelectedSlot(SlotType.COIN);
        vendingMachine.acceptPayment(new Coin(CoinType._20C));
        vendingMachine.acceptPayment(new Coin(CoinType._50C));
        vendingMachine.acceptPayment(new Coin(CoinType._10C));
        vendingMachine.acceptPayment(new Coin(CoinType._1D));

        System.out.println("Please Enter Item Number");
        vendingMachine.getKeyBad().pressKey(2);
        Item selectedItem = vendingMachine.selectItem();
        if (selectedItem != null) {
            boolean dispensed = vendingMachine.tryDispenseItem(selectedItem);
            if (dispensed) {
                System.out.println("Please Pick selected item");
                Map<PaymentType, Integer> change = vendingMachine.calculateChange();
                for (PaymentType key: change.keySet()) {
                    System.out.println("Dispensing " + change.get(key) + " of " + key.toString());
                }
            }
        }
    }

}
