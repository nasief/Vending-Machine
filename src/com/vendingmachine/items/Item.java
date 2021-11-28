package com.vendingmachine.items;

public class Item {

    private String name;
    private ItemType type;
    private int price;
    private int available;

    public Item(String name, int price, ItemType type, int available) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
