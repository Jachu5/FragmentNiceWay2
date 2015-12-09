package com.example.alfredocerezoluna.fragmentniceway.core;


import com.example.alfredocerezoluna.fragmentniceway.android.Command;
import com.example.alfredocerezoluna.fragmentniceway.android.CommandExecutor;
import com.example.alfredocerezoluna.fragmentniceway.entities.Item;
import com.example.alfredocerezoluna.fragmentniceway.entities.Observer;

import java.util.List;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class GetAllItemsUseCase implements ItemInteractor {

    private ItemGateway mItemRepository;
    private final CommandExecutor mExecutor;

    public GetAllItemsUseCase(ItemGateway itemRepository, CommandExecutor executor) {
        this.mItemRepository = itemRepository;
        this.mExecutor = executor;
    }

    @Override
    public void execute(final Observer<List<Item>> observer) {
        if (observer == null) {
            throw new RuntimeException("observer cannot be null");
        }
       this.mExecutor.run(new Command() {
           @Override
           public void run() {
               mItemRepository.getAllItems(observer);
           }
       });


    }
}
