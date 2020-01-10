package com.example.insertingdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name, email, contact;
    AutoCompleteTextView lang;
    Spinner city, country;
    Button buttonInsert;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);

        lang = findViewById(R.id.lang);

        city = findViewById(R.id.city);
        country = findViewById(R.id.county);

        buttonInsert = findViewById(R.id.insert_button);

        databaseReference = FirebaseDatabase.getInstance().getReference("user");

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValueIntoFirebase();
            }
        });
    }

    private void addValueIntoFirebase() {
        String NAME = name.getText().toString();
        String EMAIL = email.getText().toString();
        String CONTACT = contact.getText().toString();
        String LANG = lang.getText().toString();
        String CITY = city.getSelectedItem().toString();
        String COUNTRY = country.getSelectedItem().toString();

        if (!TextUtils.isEmpty(NAME) && !TextUtils.isEmpty(EMAIL)) {

            String id = databaseReference.push().getKey();

            UserModelClass userModelClass = new UserModelClass(id, NAME, EMAIL, CONTACT, LANG, CITY, COUNTRY);

            databaseReference.child(id).setValue(userModelClass);

            Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();

            name.setText("");
            email.setText("");
            contact.setText("");
            lang.setText("");

        } else {
            Toast.makeText(getApplicationContext(), "Insert value first", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.showDataActivity:
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
