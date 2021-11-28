package com.vendingmachine.components;

public class KeyBad {

    private int number;

    public void pressKey(int number) {
        this.number += this.number * 10 + number;
    }

    public int getPressed() {
        return this.number;
    }

}
