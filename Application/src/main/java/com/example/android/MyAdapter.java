package com.example.android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.recyclerview.R;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by tomer on 12-Jun-15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private List<ParseObject> contactList;

    public MyAdapter(List<ParseObject> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ParseObject ci = contactList.get(i);
        //contactViewHolder.price.setText(ci.surname);
        //contactViewHolder.img.setText(ci.email);
        contactViewHolder.vTitle.setText("hello" + " " + contactList.get(i).get("name"));
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.my_text_view, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected ImageView img;
        protected TextView price;
        protected TextView vTitle;

        public ContactViewHolder(View v) {
            super(v);
            img = (ImageView)  v.findViewById(R.id.image);
            price = (TextView)  v.findViewById(R.id.price);
            vTitle = (TextView) v.findViewById(R.id.title);
        }
    }
}