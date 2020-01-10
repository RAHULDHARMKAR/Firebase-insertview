package com.example.insertingdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    List<UserModelClass> list;

    public static final String ID_1 = "idKey";
    public static final String NAME_1 = "nameKey";
    public static final String EMAIL_1 = "emailKey";
    public static final String CONTACT_1 = "contactKey";
    public static final String LANG_1 = "langKey";
    public static final String CITY_1 = "cityKey";
    public static final String COUNTRY_1 = "countryKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        listView = (ListView) findViewById(R.id.listViewShow);
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        list = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    UserModelClass userModelClass = snap.getValue(UserModelClass.class);

                    list.add(userModelClass);
                }
                UserAdapter userAdapter = new UserAdapter(UserActivity.this,list);
                listView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserModelClass userModelClass = list.get(position);
                Intent intent = new Intent(UserActivity.this, PassDataActivity.class);
                intent.putExtra(ID_1,userModelClass.getId());
                intent.putExtra(NAME_1,userModelClass.getName());
                intent.putExtra(EMAIL_1,userModelClass.getEmail());
                intent.putExtra(CONTACT_1,userModelClass.getContact());
                intent.putExtra(LANG_1,userModelClass.getLang());
                intent.putExtra(CITY_1,userModelClass.getCity());
                intent.putExtra(COUNTRY_1,userModelClass.getCountry());

                startActivity(intent);
            }
        });

    }
}
