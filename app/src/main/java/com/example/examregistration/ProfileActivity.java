package com.example.examregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private ScrollView scrollView;
    private TextView name,registration,units,profileedit;
    private RelativeLayout first;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.image);
        name = findViewById(R.id.username);
        registration = findViewById(R.id.registration);
        units=findViewById(R.id.units);
        profileedit=findViewById(R.id.edit);
        first = findViewById(R.id.firstlayout);
        listView =findViewById(R.id.listview);


        ArrayList<String> units = new ArrayList<>();
        units.add("BCS 110 Programming in Java");
        units.add("BCS 111 Programming in Python");
        units.add("BCS 112 Programming in C++");
        units.add("BCS 113 Programming in C");
        units.add("BCS 114 Programming in Spring");
        units.add("BCS 114 Programming in PHP");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
                android.R.layout.simple_list_item_1,
                units
        );

        listView.setAdapter(adapter);


        profileedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(ProfileActivity.this,SignUpActivity.class);
              startActivity(intent);
            }
        });
    }
}