package com.example.alfredocerezoluna.fragmentniceway.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alfredocerezoluna.fragmentniceway.R;
import com.example.alfredocerezoluna.fragmentniceway.adapter.RepositoryAdapter;
import com.example.alfredocerezoluna.fragmentniceway.android.CommandExecutor;
import com.example.alfredocerezoluna.fragmentniceway.android.ThreadCommandExecutor;
import com.example.alfredocerezoluna.fragmentniceway.core.GetAllItemsUseCase;
import com.example.alfredocerezoluna.fragmentniceway.core.ItemGateway;
import com.example.alfredocerezoluna.fragmentniceway.core.ItemInteractor;
import com.example.alfredocerezoluna.fragmentniceway.entities.Item;
import com.example.alfredocerezoluna.fragmentniceway.ui.mvp.ItemList;
import com.example.alfredocerezoluna.fragmentniceway.ui.mvp.ItemListPresenter;
import com.example.alfredocerezoluna.fragmentniceway.ui.recyclerview.ItemListAdapter;

import java.util.List;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class ItemListFragmnet extends Fragment implements ItemList {
    private static final String TAG = "ItemListFragmnet";

    private RecyclerView mItemList;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemListAdapter mAdapter;

    private ItemListPresenter listPresenter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommandExecutor executor = new ThreadCommandExecutor();
        ItemGateway itemReposotory = new RepositoryAdapter();
        ItemInteractor useCase = new GetAllItemsUseCase(itemReposotory, executor);
        this.listPresenter = new ItemListPresenter(useCase, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_list,
                container, false);
        this.mItemList = (RecyclerView) view;
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initList();
        this.listPresenter.getAllItems();

    }

    private void initList() {
        this.mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        this.mItemList.setLayoutManager(mLayoutManager);
        this.mAdapter = new ItemListAdapter(this.getContext());
        this.mItemList.setAdapter(this.mAdapter);
    }

    @Override
    public void showItems(final List<Item> itemList) {

        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.setData(itemList);
                mAdapter.notifyDataSetChanged();
            }
        });

    }
}
