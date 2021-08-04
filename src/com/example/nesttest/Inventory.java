package com.example.nesttest;

import kotlin.Pair;

import java.util.HashMap;

public class Inventory {
    HashMap<Item, Integer> items = new HashMap<Item, Integer>();

    void addItem(Item item, int count) {
        this.items.put(item, count);
    }

    boolean canCraft(Item item) {
        // Inventory has the cost item
        if (this.items.containsKey(item.cost.getSecond())) {
            // Inventory has more than cost of item in inventory
            if (this.items.get(item.cost.getSecond()) > item.cost.getFirst()) {
                // Return true because we can craft
                return true;
            }
        }

        return false;
    }

    boolean craft(Item item) {
        // Inventory has the cost item
        if (this.items.containsKey(item.cost.getSecond())) {
            // Inventory has more than cost of item in inventory
            if (this.items.get(item.cost.getSecond()) >= item.cost.getFirst()) {
                // Remove the items from our inventory
                this.items.put(item.cost.getSecond(), this.items.get(item.cost.getSecond()) - item.cost.getFirst());

                // Add crafting item to our inventory
                this.items.put(item, this.items.get(item) != null ? this.items.get(item) + 1 : 1);

                // Return true because we have crafted the item successfully
                return true;
            }
        }

        return false;
    }

    boolean deepCraft(Item item) {
        Pair<Integer, Item> needToCraft = item.cost;

        // Check if we are on a bottom level item (null item cost)

        // Check if we have the items to craft
        if (this.items.containsKey(needToCraft.getSecond())) {
            if (this.items.get(needToCraft.getSecond()) >= needToCraft.getFirst()) {
                return craft(needToCraft.getSecond());
            }

            needToCraft = new Pair<Integer, Item>(needToCraft.getFirst() - this.items.get(needToCraft.getSecond()), needToCraft.getSecond());
        }

        for (int i = 0; i < needToCraft.getFirst(); i++) {
            if (this.canCraft(needToCraft.getSecond())) {
                this.craft(needToCraft.getSecond());
            } else {
                return false;
            }
        }

        return this.craft(item);
    }
}
