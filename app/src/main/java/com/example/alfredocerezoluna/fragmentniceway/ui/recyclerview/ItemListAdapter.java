package com.example.alfredocerezoluna.fragmentniceway.ui.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alfredocerezoluna.fragmentniceway.R;
import com.example.alfredocerezoluna.fragmentniceway.entities.Item;

import java.util.List;


/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder>{

    private List<Item> mItemList;

    @Override
    public ItemListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ItemListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListViewHolder holder, int position) {
        Item item = mItemList.get(position);
        holder.bindItem(item);
    }


    @Override
    public int getItemCount() {
        if(mItemList!= null){
            return mItemList.size();
        }else{
            return 0;
        }

    }

    public void setData(List<Item> itemList){
        this.mItemList = itemList;

    }

    public static class ItemListViewHolder extends RecyclerView.ViewHolder{

        TextView itemText;

        public ItemListViewHolder(View itemView) {
            super(itemView);
            itemText = (TextView) itemView.findViewById(R.id.itemName);
        }

        private void bindItem(Item item) {
            itemText.setText(item.getText());
        }

    }
}
