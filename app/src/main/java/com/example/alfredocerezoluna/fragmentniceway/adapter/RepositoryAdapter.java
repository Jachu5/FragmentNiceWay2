package com.example.alfredocerezoluna.fragmentniceway.adapter;

import com.example.alfredocerezoluna.fragmentniceway.core.ItemGateway;
import com.example.alfredocerezoluna.fragmentniceway.entities.Item;
import com.example.alfredocerezoluna.fragmentniceway.entities.Observer;

import java.util.List;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class RepositoryAdapter implements ItemGateway {

    private Repository mFakereposiroty;

    public RepositoryAdapter(Repository fakereposiroty) {
        this.mFakereposiroty = fakereposiroty;
    }

    public RepositoryAdapter() {
        this.mFakereposiroty = new Repository();
    }

    @Override
    public void getAllItems(Observer<List<Item>> observer) {
        try {
            List<Item> items = mFakereposiroty.getAllItems();
            observer.onFinished(items);
        } catch (Exception exception) {
            observer.onerror(exception);
        }


    }
}
