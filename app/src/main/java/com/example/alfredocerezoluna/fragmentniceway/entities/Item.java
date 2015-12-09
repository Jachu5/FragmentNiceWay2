package com.example.alfredocerezoluna.fragmentniceway.entities;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class Item {

    private String mText;

    public Item(String mText) {
        this.mText = mText;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }
}
