package com.example.alfredocerezoluna.fragmentniceway.ui.mvp;

import com.example.alfredocerezoluna.fragmentniceway.core.ItemInteractor;
import com.example.alfredocerezoluna.fragmentniceway.entities.Item;
import com.example.alfredocerezoluna.fragmentniceway.entities.Observer;

import java.util.List;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class ItemListPresenter {

    private final ItemInteractor mGetAllItemsUseCase;
    private final ItemList mItemList;

    public ItemListPresenter(ItemInteractor getAllItemsUseCase, ItemList itemList) {
        this.mGetAllItemsUseCase = getAllItemsUseCase;
        this.mItemList = itemList;

    }

    public void getAllItems() {
        this.mGetAllItemsUseCase.execute(new Observer<List<Item>>() {
            @Override
            public void onFinished(List<Item> result) {
                mItemList.showItems(result);
            }

            @Override
            public void onerror(Exception exception) {

            }
        });


    }
}
