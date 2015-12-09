package com.example.alfredocerezoluna.fragmentniceway.core;


import com.example.alfredocerezoluna.fragmentniceway.entities.Item;
import com.example.alfredocerezoluna.fragmentniceway.entities.Observer;

import java.util.List;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public interface ItemInteractor {

    void execute(Observer<List<Item>> observer);
}
