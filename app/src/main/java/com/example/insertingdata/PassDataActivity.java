package com.example.insertingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PassDataActivity extends AppCompatActivity {

    TextView id, name, email, contact, lang, city, country;
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
        setContentView(R.layout.activity_pass_data);

        id = findViewById(R.id.view_Id);
        name = findViewById(R.id.view_name);
        email = findViewById(R.id.view_email);
        contact = findViewById(R.id.view_contact);
        lang = findViewById(R.id.view_lang);
        city = findViewById(R.id.view_city);
        country = findViewById(R.id.view_country);

        String ID = getIntent().getStringExtra(ID_1);
        String NAME = getIntent().getStringExtra(NAME_1);
        String EMAIL = getIntent().getStringExtra(EMAIL_1);
        String CONTACT = getIntent().getStringExtra(CONTACT_1);
        String LANG = getIntent().getStringExtra(LANG_1);
        String CITY = getIntent().getStringExtra(CITY_1);
        String COUNTRY = getIntent().getStringExtra(COUNTRY_1);

        id.setText(ID);
        name.setText(NAME);
        email.setText(EMAIL);
        contact.setText(CONTACT);
        lang.setText(LANG);
        city.setText(CITY);
        country.setText(COUNTRY);


    }
}
