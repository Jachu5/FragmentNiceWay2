package com.example.alfredocerezoluna.fragmentniceway.ui.recyclerview;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alfredocerezoluna.fragmentniceway.R;
import com.example.alfredocerezoluna.fragmentniceway.android.ApplicationFragmentNiceWay;
import com.example.alfredocerezoluna.fragmentniceway.entities.Item;

import java.util.List;


/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder>{

    private static final String TAG = "ItemListAdapter";
    private List<Item> mItemList;
    private Context mContext;


    public ItemListAdapter(Context context){
        mContext = context;
    }

    @Override
    public ItemListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        ItemListViewHolder viewHolder = new ItemListViewHolder(view,new ItemListViewHolder.ItemListViewHolderClick() {
            @Override
            public void onIntemSelected(View caller, int position) {
                Log.d(TAG, "Item selected: " + position);
                ((ApplicationFragmentNiceWay) mContext).getBusInstance();

            }
        });
        return viewHolder;
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

    public static class ItemListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itemText;
        private ItemListViewHolderClick mListener;

        public ItemListViewHolder(View itemView,ItemListViewHolderClick onClickListener) {
            super(itemView);
            mListener = onClickListener;
            itemText = (TextView) itemView.findViewById(R.id.itemName);
            itemView.setOnClickListener(this);
        }

        private void bindItem(Item item) {
            itemText.setText(item.getText());
        }

        @Override
        public void onClick(View view) {
            mListener.onIntemSelected(view,this.getAdapterPosition());
        }

        public interface ItemListViewHolderClick{
            public void onIntemSelected(View caller,int position);
        }
    }
}
