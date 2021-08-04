package com.example.nesttest;

import kotlin.Pair;

public class Item {
    int id;

    Pair<Integer, Item> cost;

    public Item(int id, Pair<Integer, Item> cost) {
        this.id = id;
        this.cost = cost;
    }
}
