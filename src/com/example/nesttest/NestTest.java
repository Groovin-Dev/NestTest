package com.example.nesttest;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestTest {
    private static final Item nuget = new Item(1, new Pair<Integer, Item>(0, null));
    private static final Item ingot = new Item(2, new Pair<Integer, Item>(9, nuget));
    private static final Item block = new Item(3, new Pair<Integer, Item>(9, ingot));

    public static void main(String[] args) {
        // Inventory
        Inventory inventory = new Inventory();

        // Fill the inventory
        inventory.addItem(nuget, 100);
        inventory.addItem(ingot, 1);

        // Deep craft a block
        inventory.deepCraft(block);

        // Print our inventory
        for( Map.Entry<Item, Integer> entry : inventory.items.entrySet() ){
            System.out.println( entry.getKey().id + " => " + entry.getValue() );
        }
    }
}

