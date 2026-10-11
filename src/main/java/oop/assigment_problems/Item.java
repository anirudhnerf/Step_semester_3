package oop.assigment_problems;

// A2: this Keyword for Canteen Inventory - Batch Restock
public class Item {

    String itemName;
    int stock;

    // Parameter names match the field names, so this. tells them apart
    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    // Parameter "stock" is the restock amount; this.stock is the item's field
    void restock(int stock) {
        this.stock = this.stock + stock;
    }

    public static void main(String[] args) {
        String[] names = {"Samosa", "Tea Powder", "Bread", "Biscuit Packs"};
        int[] startingStock = {15, 40, 8, 25};

        Item[] shelf = new Item[names.length];
        for (int i = 0; i < names.length; i++) {
            shelf[i] = new Item(names[i], startingStock[i]);
        }

        // Same restock amount for every item, one pass
        for (Item item : shelf) {
            item.restock(20);
            System.out.println(item.itemName + " | Final Stock: " + item.stock);
        }
    }
}