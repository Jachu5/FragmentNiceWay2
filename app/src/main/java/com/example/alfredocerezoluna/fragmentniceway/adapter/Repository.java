package com.example.alfredocerezoluna.fragmentniceway.adapter;


import com.example.alfredocerezoluna.fragmentniceway.entities.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class Repository {

    private List<Item> itemList;

    public Repository() {
        itemList = new ArrayList<>();
        itemList.add(new Item("Hola"));
        itemList.add(new Item("Hola2"));
    }

    public List<Item> getAllItems() {
        return itemList;
    }
}
