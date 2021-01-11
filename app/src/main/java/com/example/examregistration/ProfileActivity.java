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
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private TextView name,registration,units,unitstodo;
    private RelativeLayout first;
    private ListView listView;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        db = new DatabaseHelper(ProfileActivity.this);
        name = findViewById(R.id.username);
        registration = findViewById(R.id.registration);
        units=findViewById(R.id.units);
        first = findViewById(R.id.firstlayout);
        unitstodo = findViewById(R.id.unitstodo);

        Intent intent = getIntent();
        String username= intent.getStringExtra("username");
        name.setText(username);


        ////////////////////////////////////////
        String usernm = username;

        Boolean res=  db.checkforstudentregistration(usernm);

        if(res==true){
            registration.setText("Registered");
            ArrayList<String> allfromunits;
            allfromunits=db.getStudentsUnits();

            unitstodo.setText(allfromunits.toString());
            Toast.makeText(ProfileActivity.this, "You are Registered", Toast.LENGTH_SHORT).show();


        }
        else{
            registration.setText("Not Registered");
            Toast.makeText(ProfileActivity.this, "You are Not Registered", Toast.LENGTH_SHORT).show();
        }
        ///////////////////////////////////////

    }
}