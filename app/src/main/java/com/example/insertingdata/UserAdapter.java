package com.example.insertingdata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends ArrayAdapter<UserModelClass> {

    Activity activity;
    List<UserModelClass> list;

    public UserAdapter(Activity activity, List<UserModelClass> list) {
        super(activity, R.layout.listview_layout,list);
        this.activity = activity;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.listview_layout,null,true);

        TextView id = (TextView) view.findViewById(R.id.show_id);
        TextView name = (TextView) view.findViewById(R.id.show_name);
        TextView email = (TextView) view.findViewById(R.id.show_email);
        TextView contact = (TextView) view.findViewById(R.id.show_contact);
        TextView lang = (TextView) view.findViewById(R.id.show_lang);
        TextView city = (TextView) view.findViewById(R.id.show_city);
        TextView country = (TextView) view.findViewById(R.id.show_country);

        UserModelClass userModelClass = list.get(position);

        id.setText(userModelClass.getId());
        name.setText(userModelClass.getName());
        email.setText(userModelClass.getEmail());
        contact.setText(userModelClass.getContact());
        lang.setText(userModelClass.getLang());
        city.setText(userModelClass.getCity());
        country.setText(userModelClass.getCountry());

        return view;
    }
}
